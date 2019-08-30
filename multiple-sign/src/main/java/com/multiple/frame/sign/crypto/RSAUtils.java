package com.multiple.frame.sign.crypto;

import lombok.extern.slf4j.Slf4j;

import java.security.*;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;

/**
 * RSA
 * <p>
 * 算法名称
 * [MD5withRSA,SHA1withRSA,SHA256WithRSA]
 *
 * @author: junqing.li
 * @date: 2019/8/27
 */
@Slf4j
public class RSAUtils {

    public static final String KEY_ALGORITHM = "RSA";

    public static final int KEY_SIZE = 1024;

    public static final String PUBLIC_KEY = "RSAPublicKey";

    public static final String PRIVATE_KEY = "RSAPrivateKey";

    /**
     * 初始化密钥
     */
    public static Map<String, Object> initKey() throws Exception {

        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance(KEY_ALGORITHM);
        keyPairGenerator.initialize(KEY_SIZE);
        KeyPair keyPair = keyPairGenerator.generateKeyPair();

        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();

        Map<String, Object> keyMap = new HashMap(2);
        keyMap.put(PUBLIC_KEY, publicKey);
        keyMap.put(PRIVATE_KEY, privateKey);

        return keyMap;
    }

    /**
     * 获取公钥
     *
     * @param keyMap
     * @return
     * @throws Exception
     */
    public static String getPublicKey(Map<String, Object> keyMap) {
        Key key = (Key) keyMap.get(PUBLIC_KEY);
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }

    /**
     * 取得私钥
     *
     * @param keyMap
     * @return
     * @throws Exception
     */
    public static String getPrivateKey(Map<String, Object> keyMap) {
        Key key = (Key) keyMap.get(PRIVATE_KEY);
        return Base64.getEncoder().encodeToString(key.getEncoded());
    }


    /**
     * 生成签名
     *
     * @param data
     * @param privateKey    私钥
     * @param signAlgorithm 使用的算法
     * @return
     * @throws Exception
     */
    public static String sign(byte[] data, String privateKey, String signAlgorithm) throws Exception {

        byte[] keyBytes = Base64.getDecoder().decode(privateKey);
        PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(keyBytes);

        //指定加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

        //取私钥匙对象
        PrivateKey privateSignKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);

        //用私钥对信息生成数字签名
        Signature signature = Signature.getInstance(signAlgorithm);
        signature.initSign(privateSignKey);
        signature.update(data);

        return Base64.getEncoder().encodeToString(signature.sign());
    }

    /**
     * 验证签名
     *
     * @param data
     * @param publicKey     公钥
     * @param sign          签名
     * @param signAlgorithm 算法
     * @return
     * @throws Exception
     */
    public static boolean verify(byte[] data, String publicKey, String sign, String signAlgorithm) throws Exception {

        byte[] keyBytes = Base64.getDecoder().decode(publicKey);

        //构造X509EncodedKeySpec对象
        X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(keyBytes);

        //指定加密算法
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);

        //取公钥匙对象
        PublicKey publicSignKey = keyFactory.generatePublic(x509EncodedKeySpec);

        Signature signature = Signature.getInstance(signAlgorithm);
        signature.initVerify(publicSignKey);
        signature.update(data);
        return signature.verify(Base64.getDecoder().decode(sign));
    }

}

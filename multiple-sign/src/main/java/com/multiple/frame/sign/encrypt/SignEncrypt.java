package com.multiple.frame.sign.encrypt;

/**
 * 签名算法
 *
 * @author: junqing.li
 * @date: 2019/8/27
 */
public interface SignEncrypt {


    /**
     * 算法名称
     *
     * @return
     */
    SignEncryptName encryptType();

    /**
     * 验签
     */
    boolean verifySign(SignEncryptParam param);

    /**
     * 加签
     *
     * @param
     * @return
     */
    String createSign(SignEncryptParam param);


}

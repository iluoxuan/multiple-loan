package com.multiple.frame.sign.encrypt;

import com.multiple.frame.common.exception.ChannelSingException;
import com.multiple.frame.sign.crypto.RSAUtils;
import lombok.extern.slf4j.Slf4j;

import java.nio.charset.StandardCharsets;

/**
 * @author: junqing.li
 * @date: 2019/7/11
 */
@Slf4j
public abstract class AbstractRsaSignEncrypt implements SignEncrypt {


    @Override
    public boolean verifySign(SignEncryptParam param) {

        try {
            log.info("[verifySign] to verify data={}", param.getRuleData());
            return RSAUtils.verify(param.getRuleData().getBytes(StandardCharsets.UTF_8), param.getChannelPublicKey(),
                    param.getSign(), encryptType().name());

        } catch (Exception e) {
            throw new ChannelSingException("verify sign error");
        }

    }

    @Override
    public String createSign(SignEncryptParam param) {

        try {

            String sign = RSAUtils.sign(param.getRuleData().getBytes(StandardCharsets.UTF_8), param.getPrivateKey(),
                    encryptType().name());
            return sign;

        } catch (Exception e) {

            throw new ChannelSingException("create sign error");
        }

    }
}

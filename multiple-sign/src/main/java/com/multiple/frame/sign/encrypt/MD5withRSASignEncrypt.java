package com.multiple.frame.sign.encrypt;

/**
 * @author: junqing.li
 * @date: 2019/8/31
 */
public class MD5withRSASignEncrypt extends AbstractRsaSignEncrypt {

    @Override
    public SignEncryptName encryptType() {
        return SignEncryptType.MD5withRSA;
    }
}

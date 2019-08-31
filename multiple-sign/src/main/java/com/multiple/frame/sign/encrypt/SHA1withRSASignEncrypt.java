package com.multiple.frame.sign.encrypt;

/**
 * @author: junqing.li
 * @date: 2019/8/31
 */
public class SHA1withRSASignEncrypt extends AbstractRsaSignEncrypt {

    @Override
    public SignEncryptName encryptType() {
        return SignEncryptType.SHA1withRSA;
    }
}

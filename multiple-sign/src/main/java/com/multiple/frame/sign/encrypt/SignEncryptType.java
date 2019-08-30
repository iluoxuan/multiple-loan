package com.multiple.frame.sign.encrypt;

import java.util.Arrays;

/**
 * @author: junqing.li
 * @date: 2019/7/11
 */
public enum SignEncryptType implements SignEncryptName {

    SHA1withRSA,

    MD5withRSA,

    MD5,;


    public static SignEncryptType get(String type) {

        return Arrays.stream(SignEncryptType.values())
                .filter(signEncrypt -> signEncrypt.name().equals(type)).findAny().orElse(null);
    }
}

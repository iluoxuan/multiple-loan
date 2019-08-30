package com.multiple.frame.sign.encrypt;

import lombok.Data;

/**
 * @author: junqing.li
 * @date: 2019/8/27
 */
@Data
public class SignEncryptParam {

    private String ruleData;

    private String sign;


    /**
     * 我方私钥
     *
     * @return
     */
    private String privateKey;

    /**
     * 渠道方公钥
     *
     * @return
     */
    private String channelPublicKey;


}

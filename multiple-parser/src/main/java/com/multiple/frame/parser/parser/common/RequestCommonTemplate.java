package com.multiple.frame.parser.parser.common;

import lombok.Data;

/**
 * @author: junqing.li
 * @date: 2019/8/28
 */
@Data
public class RequestCommonTemplate  extends CommonTemplate{


    private String data;

    private String time;

    private String sign;

    private String appId;

    /**
     * 产品id
     */
    private String productId;

    /**
     * 要请求的API方法名称
     */
    private String method;

    /**
     * 支持RSA 【签名类型】
     */
    private String signType;

    /**
     * data 是否需要加密
     */
    private String bizEnc;

    /**
     * string  N  RSA加密后的密钥（bizEnc为1时为必传）
     */
    private String aesKey;

    private String format;

    private String version;

    private String sourceId;

    /**
     * 压缩
     */
    private String compress;

    /**
     * 加密类型 加密类型，默认是RSA
     */
    private String encryptType;
}

package com.multiple.frame.sign.rule;

import java.util.Arrays;

/**
 * @author: junqing.li
 * @date: 2019/7/11
 */
public enum SignRuleType implements SignRuleName {

    /**
     * 将asc排序好的参数名和参数值按照key1=value1&key2=value2的方式进行拼接， 拼接后的字符串即为待签名字符串
     */
    AscAnd,

    /**
     * appid + key + appid + request.getArgs() + appid + key + appid
     */
    DoubleAnd,;

    public static SignRuleType get(String type) {

        return Arrays.stream(SignRuleType.values())
                .filter(signRuleType -> signRuleType.name().equals(type)).findAny().orElse(null);
    }
}
package com.multiple.frame.sign.rule;

import lombok.Data;

import java.util.Map;

/**
 * @author: junqing.li
 * @date: 2019/7/11
 */
@Data
public class SignRuleParam {

    /**
     * 所有参数集合
     */
    private Map<String, Object> dataMap;


    /**
     * 内部业务参数 body jsonstring
     */
    private String dataContent;

    /**
     * 渠道方appId
     */
    private String appId;


}

package com.multiple.frame.common.base;

import com.google.common.collect.Maps;
import lombok.Data;

import java.util.Map;

/**
 * @author: junqing.li
 * @date: 2019/7/19
 */
@Data
public class ChannelExchange {

    /**
     * 执行的信息
     */
    private ExecuteInfo executeInfo;

    /**
     * 返回
     */
    private Object response;

    /**
     * 渠道编码
     */
    private ChannelParam channelParam;

    /**
     * 业务功能配置
     */
    private BizFunctionConfig bizFunctionConfig;


    private Map<String, Object> attributes = Maps.newHashMap();

    public <T> T getAttribute(String name) {
        return (T) getAttributes().get(name);
    }

    public <T> T getAttributeOrDefault(String name, T defaultValue) {
        return (T) getAttributes().getOrDefault(name, defaultValue);
    }


}

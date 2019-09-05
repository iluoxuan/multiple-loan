package com.multiple.frame.core.handler;


import com.multiple.frame.common.base.ChannelExchange;

/**
 * @author: junqing.li
 * @date: 2019/7/31
 */
public interface MethodMapping {

    /**
     * 是否支持
     *
     * @param exchange
     * @return
     */
    boolean support(ChannelExchange exchange);

    /**
     * 找到可执行的
     */
    void look(ChannelExchange exchange);


}

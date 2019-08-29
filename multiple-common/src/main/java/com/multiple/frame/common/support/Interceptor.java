package com.multiple.frame.common.support;

import com.multiple.frame.common.base.ChannelExchange;

/**
 * @author: junqing.li
 * @date: 2019/8/29
 */
public interface Interceptor {

    /**
     * 处理之前
     */
    default boolean preHandle(ChannelExchange exchange) throws Exception {
        return true;
    }

    /**
     * 处理中
     */
    default void postHandle(ChannelExchange exchange) throws Exception {

    }


    /**
     * 处理之后
     */
    default void afterCompletion(ChannelExchange exchange, Throwable ex) throws Exception {

    }
}

package com.multiple.frame.common.base;

/**
 * 拦截器
 *
 * @author: junqing.li
 * @date: 2019/7/19
 */
public interface ChannelBizInterceptor {

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

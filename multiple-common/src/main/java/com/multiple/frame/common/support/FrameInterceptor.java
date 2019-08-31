package com.multiple.frame.common.support;

/**
 * 身份拦截器
 *
 * @author: junqing.li
 * @date: 2019/8/29
 */
public interface FrameInterceptor extends Interceptor {

    /**
     * 拦截器名称
     * 【配置了 才拦截】
     *
     * @return
     */
    InterceptorKey nameKey();
}

package com.multiple.frame.common.support;

import com.multiple.frame.common.base.ChannelExchange;

/**
 * 返回值 处理
 *
 * @author: junqing.li
 * @date: 2019/8/29
 */
public interface ReturnValueHandler {

    /**
     * 支持参数
     *
     * @return
     */
    boolean supports(ChannelExchange exchange);

    /**
     * 处理
     *
     * @param exchange
     */
    void handleReturnValue(ChannelExchange exchange);
}

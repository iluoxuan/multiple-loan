package com.multiple.frame.common.support;

import com.multiple.frame.common.base.ChannelExchange;

/**
 * 异常处理
 *
 * @author: junqing.li
 * @date: 2019/8/29
 */
public interface ExceptionHandler {

    /**
     * 异常处理
     *
     * @param exchange
     * @param e
     */
    void handlerException(ChannelExchange exchange, Exception e);
}

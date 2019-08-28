package com.multiple.frame.parser.template;

import com.multiple.frame.common.base.ChannelExchange;

/**
 * @author: junqing.li
 * @date: 2019/8/28
 */
public interface View {

    /**
     * 解析结果
     *
     * @param exchange
     */
    void resolveResponse(ChannelExchange exchange);

    /**
     * 解析请求
     *
     * @param exchange
     */
    void resolveRequest(ChannelExchange exchange);

    /**
     * 引擎
     *
     * @return
     */
    String engine();
}

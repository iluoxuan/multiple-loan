package com.multiple.frame.parser.interceptor;

import com.multiple.frame.common.support.ChannelBizInterceptor;
import com.multiple.frame.common.base.ChannelExchange;

/**
 * @author: junqing.li
 * @date: 2019/8/28
 */
public class ResolveRequestBizInterceptor implements ChannelBizInterceptor {

    @Override
    public boolean preHandle(ChannelExchange exchange) throws Exception {
        return true;
    }
}

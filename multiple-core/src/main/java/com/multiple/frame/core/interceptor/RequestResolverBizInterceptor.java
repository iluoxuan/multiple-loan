package com.multiple.frame.core.interceptor;

import com.multiple.frame.common.support.GlobalInterceptor;
import com.multiple.frame.common.base.ChannelExchange;
import com.multiple.frame.core.support.ArgumentResolverComposite;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: junqing.li
 * @date: 2019/8/29
 */
@Setter
@Slf4j
public class RequestResolverBizInterceptor implements GlobalInterceptor {

    private ArgumentResolverComposite argumentResolverComposite;

    @Override
    public boolean preHandle(ChannelExchange exchange) throws Exception {

        argumentResolverComposite.resolveArgument(exchange);

        return true;
    }
}

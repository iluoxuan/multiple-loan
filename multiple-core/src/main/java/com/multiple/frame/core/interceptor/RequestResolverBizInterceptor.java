package com.multiple.frame.core.interceptor;

import com.multiple.frame.common.base.BizInterceptorOrder;
import com.multiple.frame.common.support.GlobalInterceptor;
import com.multiple.frame.common.base.ChannelExchange;
import com.multiple.frame.core.support.ArgumentResolverComposite;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;

/**
 * @author: junqing.li
 * @date: 2019/8/29
 */
@Setter
@Slf4j
public class RequestResolverBizInterceptor implements GlobalInterceptor, Ordered {

    private ArgumentResolverComposite argumentResolverComposite;

    @Override
    public boolean preHandle(ChannelExchange exchange) throws Exception {

        argumentResolverComposite.resolveArgument(exchange);

        return true;
    }

    @Override
    public int getOrder() {
        return BizInterceptorOrder.argumentResolve;
    }
}

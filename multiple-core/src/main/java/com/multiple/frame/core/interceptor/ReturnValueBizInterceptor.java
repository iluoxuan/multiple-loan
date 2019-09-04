package com.multiple.frame.core.interceptor;

import com.multiple.frame.common.base.BizInterceptorOrder;
import com.multiple.frame.common.base.ChannelExchange;
import com.multiple.frame.common.support.GlobalInterceptor;
import com.multiple.frame.core.support.ReturnValueHandlerComposite;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;

/**
 * @author: junqing.li
 * @date: 2019/8/29
 */
@Setter
@Slf4j
public class ReturnValueBizInterceptor implements GlobalInterceptor, Ordered {

    private ReturnValueHandlerComposite returnValueHandlerComposite;

    @Override
    public void postHandle(ChannelExchange exchange) throws Exception {

        returnValueHandlerComposite.handleReturnValue(exchange);
    }

    @Override
    public int getOrder() {
        return BizInterceptorOrder.returnValueHandler;
    }
}

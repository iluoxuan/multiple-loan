package com.multiple.frame.core.interceptor;

import com.multiple.frame.common.base.ChannelExchange;
import com.multiple.frame.common.support.ChannelBizInterceptor;
import com.multiple.frame.core.support.ReturnValueHandlerComposite;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: junqing.li
 * @date: 2019/8/29
 */
@Setter
@Slf4j
public class ReturnValueBizInterceptor implements ChannelBizInterceptor {

    private ReturnValueHandlerComposite returnValueHandlerComposite;

    @Override
    public void postHandle(ChannelExchange exchange) throws Exception {

        returnValueHandlerComposite.handleReturnValue(exchange);
    }
}

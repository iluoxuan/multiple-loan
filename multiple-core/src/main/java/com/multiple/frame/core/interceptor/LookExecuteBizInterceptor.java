package com.multiple.frame.core.interceptor;

import com.multiple.frame.common.base.ChannelBizInterceptor;
import com.multiple.frame.common.base.ChannelExchange;
import com.multiple.frame.core.handler.MethodMappingManager;
import lombok.Getter;
import lombok.Setter;

/**
 * @author: junqing.li
 * @date: 2019/8/27
 */
@Getter
@Setter
public class LookExecuteBizInterceptor implements ChannelBizInterceptor {


    private MethodMappingManager methodMappingManager;

    @Override
    public boolean preHandle(ChannelExchange exchange) throws Exception {

        methodMappingManager.handler(exchange);

        return true;
    }
}

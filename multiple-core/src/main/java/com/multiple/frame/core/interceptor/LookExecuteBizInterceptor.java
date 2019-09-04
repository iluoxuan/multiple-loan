package com.multiple.frame.core.interceptor;

import com.multiple.frame.common.base.BizInterceptorOrder;
import com.multiple.frame.common.support.GlobalInterceptor;
import com.multiple.frame.common.base.ChannelExchange;
import com.multiple.frame.core.handler.method.MethodMappingManager;
import lombok.Getter;
import lombok.Setter;
import org.springframework.core.Ordered;

/**
 * @author: junqing.li
 * @date: 2019/8/27
 */
@Getter
@Setter
public class LookExecuteBizInterceptor implements GlobalInterceptor, Ordered {


    private MethodMappingManager methodMappingManager;

    @Override
    public boolean preHandle(ChannelExchange exchange) throws Exception {

        methodMappingManager.handler(exchange);

        return true;
    }

    @Override
    public int getOrder() {
        return BizInterceptorOrder.lookExecute;
    }
}

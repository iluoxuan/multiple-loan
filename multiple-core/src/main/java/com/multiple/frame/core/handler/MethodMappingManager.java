package com.multiple.frame.core.handler;

import com.multiple.frame.common.base.ChannelExchange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;

/**
 * @author: junqing.li
 * @date: 2019/8/28
 */
public class MethodMappingManager {

    @Autowired
    private List<MethodMapping> methodMappings;

    public void handler(ChannelExchange exchange) {


        for (MethodMapping methodMapping : methodMappings) {
            if (methodMapping.support(exchange)) {
                methodMapping.look(exchange);
            }
        }

       // Assert.notNull(exchange.getExecuteInfo(), "no find execute info");

    }

}

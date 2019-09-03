package com.multiple.frame.core.handler.method;

import com.google.common.collect.Maps;
import com.multiple.frame.common.base.ChannelExchange;
import com.multiple.frame.common.base.ExecuteInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;

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

    }

}

package com.multiple.frame.core.handler;

import com.google.common.collect.Maps;
import com.multiple.frame.common.base.ChannelExchange;
import com.multiple.frame.common.base.ChannelParam;
import com.multiple.frame.common.base.ExecuteInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import java.util.List;
import java.util.Map;
import java.util.Objects;

/**
 * @author: junqing.li
 * @date: 2019/8/28
 */
public class MethodMappingManager {

    /**
     * methodName -> 执行bean 缓存
     */
    private static final Map<String, ExecuteInfo> executeInfoCache = Maps.newConcurrentMap();


    @Autowired
    private List<MethodMapping> methodMappings;

    public void handler(ChannelExchange exchange) {

        String cacheKey = getCacheKey(exchange);
        ExecuteInfo executeInfo = executeInfoCache.get(cacheKey);
        if (Objects.nonNull(executeInfo)) {
            exchange.setExecuteInfo(executeInfo);
            return;
        }

        for (MethodMapping methodMapping : methodMappings) {
            if (methodMapping.support(exchange)) {
                methodMapping.look(exchange);
            }
        }

        executeInfo = exchange.getExecuteInfo();
        Assert.notNull(executeInfo, "no find execute info");
        Assert.notNull(executeInfo.getChannelInfo(), "no find execute bean info");
        Assert.notNull(executeInfo.getMethod(), "no find execute method info");

        executeInfoCache.put(cacheKey, executeInfo);
    }

    private String getCacheKey(ChannelExchange exchange) {

        ChannelParam param = exchange.getChannelParam();

        return String.format("%s-%s", param.getChannelCode(), param.getBizMethod());
    }
}

package com.multiple.frame.core.register;

import com.google.common.collect.Maps;
import com.multiple.frame.common.base.ExecuteInfo;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * @author: junqing.li
 * @date: 2019/9/3
 */
public class DefaultExecuteRegister implements ExecuteRegister {

    private static final Map<String, ExecuteInfo> executeMap = Maps.newHashMap();

    @Override
    public void register(ExecuteInfo executeInfo) {

        String cacheKey = getCacheKey(executeInfo.getChannel(),
                executeInfo.getUnitBiz(), executeInfo.getMethod().getName());

        executeMap.put(cacheKey, executeInfo);


    }

    @Override
    public ExecuteInfo lookUp(String channel, String method, String[] unitBiz) {

        String cacheKey = getCacheKey(channel,
                unitBiz, method);

        return executeMap.get(cacheKey);
    }

    @Override
    public List<ExecuteInfo> all() {

        return executeMap.entrySet().stream().map(entry -> entry.getValue())
                .collect(Collectors.toList());

    }


    private String getCacheKey(String channel, String[] unitBiz, String method) {

        String format = "%s-%s-%s";
        if (Objects.isNull(unitBiz)) {
            return String.format(format, channel, "", method);
        }
        return String.format(format, channel, unitBiz[0], method);
    }

    @Override
    public void clear() {
        executeMap.clear();
    }
}

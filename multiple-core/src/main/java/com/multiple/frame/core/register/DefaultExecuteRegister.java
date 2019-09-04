package com.multiple.frame.core.register;

import com.google.common.collect.Maps;
import com.multiple.frame.common.base.BizUnit;
import com.multiple.frame.common.base.DefaultBiz;
import com.multiple.frame.common.base.ExecuteInfo;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * @author: junqing.li
 * @date: 2019/9/3
 */
public class DefaultExecuteRegister implements ExecuteRegister {

    /**
     * 已经有注册的缓存
     * 【没有注册的渠道】
     */
    private static final Map<String, ExecuteInfo> executeMap = Maps.newHashMap();


    @Override
    public void register(ExecuteInfo executeInfo) {

        String cacheKey = getCacheKey(executeInfo.getChannel(),
                executeInfo.getUnitBiz(), executeInfo.getMethod().getName());

        executeMap.put(cacheKey, executeInfo);


    }

    @Override
    public ExecuteInfo lookUp(String channel, String method, List<String> unitBiz) {

        String cacheKey = getCacheKey(channel,
                unitBiz, method);

        ExecuteInfo executeInfo = executeMap.get(cacheKey);

        if (!ExecuteInfo.isNull(executeInfo)) {
            return executeInfo;
        }

        // 为空说明，对应的注册成default了
        cacheKey = getCacheKey(DefaultBiz.defaultBiz, unitBiz, method);
        return executeMap.get(cacheKey);

    }

    @Override
    public Map<String, ExecuteInfo> all() {

        return executeMap;

    }


    private String getCacheKey(String channel, List<String> unitBiz, String method) {

        String format = "%s-%s-%s";
        if (CollectionUtils.isEmpty(unitBiz)) {
            return String.format(format, channel, BizUnit.defaultBiz, method);
        }
        return String.format(format, channel, unitBiz.get(0), method);
    }

    @Override
    public void clear() {
        executeMap.clear();
    }
}

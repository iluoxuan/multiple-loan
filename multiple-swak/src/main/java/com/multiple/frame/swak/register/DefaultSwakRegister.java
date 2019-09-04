package com.multiple.frame.swak.register;

import com.google.common.collect.Maps;
import com.multiple.frame.swak.entity.ExecuteInfo;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.Map;

/**
 * @author: junqing.li
 * @date: 2019/9/4
 */
public class DefaultSwakRegister implements SwakRegister {

    /**
     * 缓存
     */
    private final static Map<String, ExecuteInfo> executeInfoCache = Maps.newHashMap();

    @Override
    public void register(ExecuteInfo executeInfo) {

        if (CollectionUtils.isEmpty(executeInfo.getTags())) {
            return;
        }

        executeInfo.getTags().stream().forEach(tag -> executeInfoCache.put(tag, executeInfo));

    }

    @Override
    public ExecuteInfo lookUp(List<String> tags) {

        // 先直接用第一个取 TODO
        return executeInfoCache.get(tags.get(0));
    }

    @Override
    public void clear() {

        executeInfoCache.clear();

    }
}

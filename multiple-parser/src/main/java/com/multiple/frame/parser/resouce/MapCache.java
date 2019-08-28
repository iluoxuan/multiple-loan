package com.multiple.frame.parser.resouce;

import com.google.common.collect.Maps;
import org.springframework.stereotype.Component;

import java.util.Map;

/**
 * @author: junqing.li
 * @date: 2019/8/28
 */
@Component
public class MapCache implements ResourceCache {

    /**
     * 简单的全部缓存
     */
    private final static Map<String, TemplateResource> mapCache = Maps.newConcurrentMap();

    @Override
    public TemplateResource get(String resourceKey) {
        return mapCache.get(resourceKey);
    }

    @Override
    public TemplateResource put(String resourceKey, TemplateResource resource) {
        return mapCache.put(resourceKey, resource);
    }

    @Override
    public TemplateResource remove(String resourceKey) {
        return mapCache.remove(resourceKey);
    }

    @Override
    public void clear() {
        mapCache.clear();
    }
}

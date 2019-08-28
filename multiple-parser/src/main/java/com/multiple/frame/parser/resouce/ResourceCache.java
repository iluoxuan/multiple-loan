package com.multiple.frame.parser.resouce;

/**
 * 资源 缓存
 * @author: junqing.li
 * @date: 2019/8/28
 */
public interface ResourceCache {

    /**
     * retrieves a Resource from the
     * cache
     *
     * @param resourceKey key for Resource to be retrieved
     * @return Resource specified or null if not found
     */
    TemplateResource get(String resourceKey);

    /**
     * stores a Resource in the cache
     *
     * @param resourceKey key to associate with the Resource
     * @param resource    Resource to be stored
     * @return existing Resource stored under this key, or null if none
     */
    TemplateResource put(String resourceKey, TemplateResource resource);

    /**
     * removes a Resource from the cache
     *
     * @param resourceKey resource to be removed
     * @return stored under key
     */
    TemplateResource remove(String resourceKey);

    /**
     * Removes all of the resources from this cache.
     * The cache will be empty after this call returns.
     *
     * @since 2.0
     */
    void clear();

}
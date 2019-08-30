package com.multiple.frame.common.base;

/**
 * @author: junqing.li
 * @date: 2019/8/30
 */
public interface BaseEnum<T> {

    /**
     * 获取T
     * @param key
     * @return
     */
    T getByKey(String key);
}

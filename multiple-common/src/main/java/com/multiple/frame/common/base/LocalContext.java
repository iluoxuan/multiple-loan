package com.multiple.frame.common.base;

import java.util.concurrent.ConcurrentHashMap;

/**
 * 添加上下文副本
 *
 * @author: junqing.li
 * @date: 2019/8/8
 */
public class LocalContext extends ConcurrentHashMap<String, Object> {

    private static Class<? extends LocalContext> contextClass = LocalContext.class;


    private static final ThreadLocal<? extends LocalContext> threadLocal = ThreadLocal.withInitial(
            () -> {
                try {
                    return contextClass.newInstance();
                } catch (Throwable e) {
                    throw new RuntimeException(e);
                }
            });

    public LocalContext() {
        super();
    }

    public static LocalContext getCurrentContext() {
        LocalContext context = threadLocal.get();
        return context;
    }

    public boolean getBoolean(String key) {
        return getBoolean(key, false);
    }

    public boolean getBoolean(String key, boolean defaultResponse) {
        Boolean b = (Boolean) get(key);
        if (b != null) {
            return b.booleanValue();
        }
        return defaultResponse;
    }

    public <T> T getObject(String key) {

        return (T) get(key);
    }

    public <T> T getObjectOrDefault(String key, T defaultValue) {

        return (T) getOrDefault(key, defaultValue);
    }

    public void set(String key) {
        put(key, Boolean.TRUE);
    }

    /**
     * puts the key, value into the map. a null value will remove the key from the map
     */
    public void set(String key, Object value) {
        if (value != null) {
            put(key, value);
        } else {
            remove(key);
        }
    }

    /**
     * unsets the threadLocal context. Done at the end of the request.
     */
    public void unset() {
        threadLocal.remove();
    }

    public void setChannel(String channel) {
        set("channel", channel);
    }

    public String channel() {
        return (String) get("channel");
    }

    public void setUnitBiz(String unitBiz) {
        set("unitBiz", unitBiz);
    }

    public String unitBiz() {
        return (String) get("unitBiz");
    }

}

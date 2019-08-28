package com.multiple.frame.common.utils;

import lombok.extern.slf4j.Slf4j;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author: junqing.li
 * @date: 2019/8/27
 */
@Slf4j
public class ReflectUtils {

    /**
     * 寻找当前类上的 处理方法 1. 不寻找父类 2. 父类找不到
     */
    public static Method getDeclaredMethod(Object object, String methodName, Class<?>... parameterTypes) {

        if (Objects.isNull(object)) {
            return null;
        }

        try {
            Method method = object.getClass().getDeclaredMethod(methodName, parameterTypes);
            return method;
        } catch (NoSuchMethodException e) {
            log.info("[getDeclaredMethod] no find method={} user default", methodName);
        }

        return null;

    }
}

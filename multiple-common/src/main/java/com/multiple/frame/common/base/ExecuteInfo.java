package com.multiple.frame.common.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;
import java.util.Objects;

/**
 * @author: junqing.li
 * @date: 2019/8/27
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExecuteInfo {

    /**
     * 执行的方法
     */
    private Method method;

    /**
     * 接口
     */
    private Object bean;

    private String channel;

    private String[] unitBiz;

    public static boolean isNull(ExecuteInfo info) {

        if (Objects.isNull(info)) {
            return true;
        }

        return Objects.isNull(info.getMethod()) || Objects.isNull(info.getBean());
    }

}

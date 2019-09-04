package com.multiple.frame.common.base;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.lang.reflect.Method;
import java.util.List;
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

    private List<String> unitBiz;

    public static boolean isNull(ExecuteInfo info) {

        if (Objects.isNull(info)) {
            return true;
        }

        return Objects.isNull(info.getMethod()) || Objects.isNull(info.getBean());
    }

    @Override
    public String toString() {
        String format = "{\"channel\":\"%s\",\"unitBiz\":\"%s\",\"method\":\"%s\",\"bean\":\"%s\"}";
        String methodName = Objects.isNull(method) ? "" : method.getName();
        String beanClass = Objects.isNull(bean) ? "" : bean.getClass().toString();
        return String.format(format, channel, unitBiz, methodName, beanClass);
    }

}

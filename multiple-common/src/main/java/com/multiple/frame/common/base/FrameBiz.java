package com.multiple.frame.common.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 扩展类
 * <p>
 * 先找到 channel ---> bizUnit[空]---> 执行channel
 *
 * @author: junqing.li
 * @date: 2019/7/10
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface FrameBiz {


    /**
     * 业务线
     *
     * @return
     */
    String channel() default "";

    /**
     * 业务单元组
     *
     * @return
     */
    String[] bizUnit() default {};

}
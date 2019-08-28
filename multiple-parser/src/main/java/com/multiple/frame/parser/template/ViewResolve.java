package com.multiple.frame.parser.template;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 视图渲染注解
 *
 * @author: junqing.li
 * @date: 2019/7/25
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface ViewResolve {

    boolean response() default true;

    /**
     * 使用的那个模板
     */
    String engine() default "";

    /**
     * 参数解析
     *
     * @return
     */
    boolean request() default true;


}
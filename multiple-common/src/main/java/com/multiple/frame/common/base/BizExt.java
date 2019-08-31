package com.multiple.frame.common.base;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 扩展类
 *
 * @author: junqing.li
 * @date: 2019/7/10
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface BizExt {


    String value() default BizUnit.defaultBiz;

}
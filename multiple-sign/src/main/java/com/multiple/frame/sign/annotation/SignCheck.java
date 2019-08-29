package com.multiple.frame.sign.annotation;

import org.springframework.core.annotation.AliasFor;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 是否需要验签
 *
 * @author: junqing.li
 * @date: 2019/7/10
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface SignCheck {

  @AliasFor("name")
  boolean value() default true;

  @AliasFor("value")
  boolean name() default true;

}

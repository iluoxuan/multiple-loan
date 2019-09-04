package com.multiple.frame.core.endpoint;

import org.springframework.core.DecoratingProxy;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.lang.Nullable;

import java.lang.reflect.AnnotatedElement;
import java.lang.reflect.Method;

/**
 * @author: junqing.li
 * @date: 2019/9/4
 */
public class OrderUtils extends org.springframework.core.annotation.OrderUtils {

    @Nullable
    public static Integer findOrder(Object obj) {

        // Check for regular Ordered interface
        Integer order = (obj instanceof Ordered ? ((Ordered) obj).getOrder() : null);

        if (order != null) {
            return order;
        }

        // Check for @Order and @Priority on various kinds of elements
        if (obj instanceof Class) {
            return getOrder((Class<?>) obj);
        } else if (obj instanceof Method) {
            Order ann = AnnotationUtils.findAnnotation((Method) obj, Order.class);
            if (ann != null) {
                return ann.value();
            }
        } else if (obj instanceof AnnotatedElement) {
            Order ann = AnnotationUtils.getAnnotation((AnnotatedElement) obj, Order.class);
            if (ann != null) {
                return ann.value();
            }
        } else {
            order = getOrder(obj.getClass());
            if (order == null && obj instanceof DecoratingProxy) {
                order = getOrder(((DecoratingProxy) obj).getDecoratedClass());
            }
        }

        return order;
    }
}

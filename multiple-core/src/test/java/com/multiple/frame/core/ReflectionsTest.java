package com.multiple.frame.core;

import com.multiple.frame.common.base.FrameInterface;
import org.junit.Test;
import org.reflections.Reflections;

import java.util.Set;

/**
 * @author: junqing.li
 * @date: 2019/9/3
 */
public class ReflectionsTest {

    @Test
    public void scanAnnotation() {

        System.out.println("xxxx");

        Reflections reflections = new Reflections();
        Set<Class<?>> set = reflections.getTypesAnnotatedWith(FrameInterface.class);

    }
}

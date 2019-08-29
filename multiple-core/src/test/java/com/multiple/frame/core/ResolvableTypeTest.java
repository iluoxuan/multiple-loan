package com.multiple.frame.core;

import org.junit.Test;
import org.mockito.internal.util.reflection.Fields;
import org.springframework.core.MethodParameter;
import org.springframework.core.ResolvableType;

import javax.validation.constraints.NotNull;
import java.lang.reflect.Field;
import java.lang.reflect.GenericArrayType;
import java.lang.reflect.Method;
import java.lang.reflect.Type;
import java.util.ArrayList;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * spring {@link ResolvableType} 测试
 *
 * @author: junqing.li
 * @date: 2019/8/29
 */
public class ResolvableTypeTest {

    static class ExtendsList extends ArrayList<CharSequence> {

        @NotNull
        public String charSequenceParameter(String hello) {
            return "xxxx";
        }
    }

    @Test
    public void forClass() throws Exception {

        ResolvableType type = ResolvableType.forClass(ExtendsList.class);

        assertThat(type.getType(), equalTo(ExtendsList.class));
    }

    @Test
    public void forField() throws Exception {
        Field field = Fields.class.getField("charSequenceList");
        ResolvableType type = ResolvableType.forField(field);
        assertThat(type.getType(), equalTo(field.getGenericType()));
    }


    @Test
    public void forMethodParameter() throws Exception {
        Method method = ExtendsList.class.getMethod("charSequenceParameter", String.class);
        MethodParameter methodParameter = MethodParameter.forExecutable(method, 0);
        ResolvableType type = ResolvableType.forMethodParameter(methodParameter);
        assertThat(type.getType(), equalTo(method.getGenericParameterTypes()[0]));
    }

    @Test
    public void forClassTest() throws Exception {
        ResolvableType type = ResolvableType.forClass(ExtendsList.class);
        assertThat(type.getType(), equalTo((Type) ExtendsList.class));
        assertThat(type.getRawClass(), equalTo(ExtendsList.class));
    }

    @Test
    public void superTypeTest() throws Exception {
        ResolvableType type = ResolvableType.forType(ExtendsList.class);
        ResolvableType superType = type.getSuperType();
        System.out.println(superType.getType());
    }

    @Test
    public void getRawClassTest() throws Exception {
        ResolvableType type = ResolvableType.forType(ExtendsList.class);
        ResolvableType superType = type.getSuperType();
        System.out.println(superType.getRawClass());
    }

    @Test
    public void asTest() throws Exception {
        ResolvableType type = ResolvableType.forType(ExtendsList.class);
        ResolvableType listType = type.as(ArrayList.class);
        System.out.println(listType.getType());
        System.out.println(listType.getRawClass());
    }

    @Test
    public void getGenericTest() throws Exception {
        ResolvableType type = ResolvableType.forType(ExtendsList.class);
        ResolvableType listType = type.as(ArrayList.class);
        System.out.println(listType.getGeneric().getType());
    }

    @Test
    public void getComponentTypeForClassArray() throws Exception {
        Field field = Fields.class.getField("arrayClassType");
        ResolvableType type = ResolvableType.forField(field);
        assertThat(type.isArray(), equalTo(true));
        assertThat(type.getComponentType().getType(),
                equalTo((Type) ((Class) field.getGenericType()).getComponentType()));
    }

    @Test
    public void getComponentTypeForGenericArrayType() throws Exception {
        ResolvableType type = ResolvableType.forField(Fields.class.getField("genericArrayType"));
        assertThat(type.isArray(), equalTo(true));
        assertThat(type.getComponentType().getType(),
                equalTo(((GenericArrayType) type.getType()).getGenericComponentType()));
    }

}

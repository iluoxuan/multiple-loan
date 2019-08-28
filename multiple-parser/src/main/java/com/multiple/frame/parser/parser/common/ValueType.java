package com.multiple.frame.parser.parser.common;

/**
 * @author: junqing.li
 * @date: 2019/8/28
 */
public enum ValueType {

    STRING,

    INT,

    LONG,

    OBJECT,

    DOUBLE,;

    public static boolean isString(String value) {

        return STRING.name().equalsIgnoreCase(value);
    }

    public static boolean isInt(String value) {

        return INT.name().equalsIgnoreCase(value);
    }

    public static boolean isObject(String value) {

        return OBJECT.name().equalsIgnoreCase(value);
    }

    public static boolean isLong(String value) {

        return LONG.name().equalsIgnoreCase(value);
    }

    public static boolean isDouble(String value) {

        return DOUBLE.name().equalsIgnoreCase(value);
    }


}

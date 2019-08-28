package com.multiple.frame.parser.parser.common;

import com.google.common.collect.Maps;
import lombok.Getter;
import lombok.Setter;

import java.util.Map;

/**
 * @author: junqing.li
 * @date: 2019/8/28
 */
@Getter
@Setter
public abstract class CommonTemplate {

    /**
     * map key值的map
     */
    protected Map<String, String> mapping;

    /**
     * 要启用的业务
     */
    protected Map<String, String> biz;

    /**
     * 默认字段值
     */
    protected Map<String, MappingValueFormat> formatValueMap = Maps.newHashMap();
}

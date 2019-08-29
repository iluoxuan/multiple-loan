package com.multiple.frame.common.base;

import com.google.common.collect.Sets;
import lombok.Data;

import java.util.Set;

/**
 * @author: junqing.li
 * @date: 2019/8/29
 */
@Data
public class BizFunctionConfig {

    /**
     * 启用的拦截器
     */
    private Set<String> interceptorKeys = Sets.newHashSet();

    /**
     * 要启用的业务
     */
    private String bizUnit;
}

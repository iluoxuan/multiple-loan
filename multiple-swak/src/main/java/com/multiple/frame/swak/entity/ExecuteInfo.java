package com.multiple.frame.swak.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author: junqing.li
 * @date: 2019/9/4
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ExecuteInfo {

    /**
     * 目标对象
     */
    private Object target;

    /**
     * 所有的tag
     */
    private List<String> tags;

    /**
     * 业务线
     */
    private String bizCode;

}

package com.multiple.frame.swak.entity;

import lombok.Data;

import java.util.List;

/**
 * @author: junqing.li
 * @date: 2019/9/4
 */
@Data
public class SwakContext {

    private List<String> tags;

    private String bizCode;
}

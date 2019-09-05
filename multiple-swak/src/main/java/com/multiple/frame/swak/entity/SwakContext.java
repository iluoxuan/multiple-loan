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
public class SwakContext {

    private List<String> tags;

    private String bizCode;
}

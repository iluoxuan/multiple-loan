package com.multiple.frame.swak.entity;

import com.multiple.frame.swak.config.SwakConstants;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Arrays;
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

    private String bizCode = SwakConstants.swakDefaultBiz;

    public SwakContext(List<String> tags) {
        this.tags = tags;
    }

    public SwakContext(String... tags) {
        this.tags = Arrays.asList(tags);
    }
}

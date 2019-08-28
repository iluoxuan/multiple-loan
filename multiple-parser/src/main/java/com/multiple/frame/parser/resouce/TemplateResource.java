package com.multiple.frame.parser.resouce;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author: junqing.li
 * @date: 2019/8/28
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
public class TemplateResource {

    /**
     * 模板内容
     */
    private String data;
}

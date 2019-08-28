package com.multiple.frame.parser.config;

import lombok.Getter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: junqing.li
 * @date: 2019/8/28
 */
@Getter
@ConfigurationProperties(prefix = "multiple.parser")
@Configuration
public class ParserProperties {

    /**
     * 模板后缀 [.vm]
     */
    private String templateSuffix;

    /**
     * 模板路径 [%s/req/%s]等
     */
    private String templatePath = "template/%s/req";

    /**
     * 默认不开启
     */
    private boolean cacheStart = false;

}

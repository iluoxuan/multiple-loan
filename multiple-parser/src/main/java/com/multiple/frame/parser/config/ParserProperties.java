package com.multiple.frame.parser.config;

import com.multiple.frame.parser.resouce.ResourceType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: junqing.li
 * @date: 2019/8/28
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "multiple.parser")
@Configuration
public class ParserProperties {

    /**
     * 模板后缀 [.vm]
     */
    private String templateSuffix = ".json";

    /**
     * 模板路径 [%s/req/%s]等
     */
    private String templatePath = "template/%s/req";

    /**
     * 默认不开启
     */
    private boolean cacheStart = false;

    /**
     * 配置获取方式
     * {@link ResourceType}
     */
    private String resourceLoaderType = ResourceType.classpath;

}

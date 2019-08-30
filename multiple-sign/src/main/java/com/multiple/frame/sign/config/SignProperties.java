package com.multiple.frame.sign.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: junqing.li
 * @date: 2019/8/29
 */
@Setter
@Getter
@Configuration
@ConfigurationProperties(prefix = "multiple.sign")
public class SignProperties {

    /**
     * 跳过check
     */
    private boolean skipCheck = false;

}

package com.multiple.frame.core.config;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author: junqing.li
 * @date: 2019/8/27
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "multiple.frame")
@Configuration
public class MultipleFrameProperties {


}

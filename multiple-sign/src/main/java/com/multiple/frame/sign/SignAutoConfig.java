package com.multiple.frame.sign;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author: junqing.li
 * @date: 2019/8/27
 */
@ComponentScan
@EnableAutoConfiguration
@Configuration
public class SignAutoConfig {

    @Bean
    public SignManager signManager() {
        return new SignManager();
    }

}

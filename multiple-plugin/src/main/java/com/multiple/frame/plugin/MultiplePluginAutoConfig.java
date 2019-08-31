package com.multiple.frame.plugin;

import com.multiple.frame.plugin.config.PluginProperties;
import com.multiple.frame.plugin.interception.UnCompressInterception;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnExpression;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author: junqing.li
 * @date: 2019/8/31
 */
@EnableConfigurationProperties(PluginProperties.class)
@Configuration
public class MultiplePluginAutoConfig {


    @Autowired
    private PluginProperties pluginProperties;


    @Bean
    @ConditionalOnExpression("#{environment.containsProperty('multiple.plugin.load.unCompress')}")
    @ConditionalOnMissingBean(name = "unCompressInterception")
    public UnCompressInterception unCompressInterception() {

        UnCompressInterception interception = new UnCompressInterception();
        interception.setPluginProperties(pluginProperties);
        return interception;
    }
}

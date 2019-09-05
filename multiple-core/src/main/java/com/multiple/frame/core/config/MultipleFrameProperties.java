package com.multiple.frame.core.config;

import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import java.util.Map;
import java.util.Set;

/**
 * @author: junqing.li
 * @date: 2019/8/27
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "multiple.frame")
@Configuration
public class MultipleFrameProperties {

    /**
     * 配置要开启的 拦截器
     */
    private Map<String, Set<String>> interceptorKeys = Maps.newHashMap();

    /**
     * 默认的所有的渠道都执行
     */
    private Set<String> defaultKeys = Sets.newHashSet();




    public Set<String> getByChannel(String channel) {

        Set<String> result = getDefaultKeys();
        result.addAll(interceptorKeys.get(channel));
        return result;
    }

}

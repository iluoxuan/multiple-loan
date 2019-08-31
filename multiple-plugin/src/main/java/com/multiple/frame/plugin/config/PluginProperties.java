package com.multiple.frame.plugin.config;

import com.multiple.frame.plugin.common.PluginInterceptorKey;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.assertj.core.util.Lists;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @author: junqing.li
 * @date: 2019/8/31
 */
@Setter
@Getter
@ConfigurationProperties(prefix = "multiple.plugin")
@Configuration
public class PluginProperties {

    /**
     * 加载 相关插件
     */
    @Valid
    private List<LoadConfig> load = Lists.newArrayList();


    @Data
    public static class LoadConfig {

        /**
         * key
         */
        @NotNull
        private PluginInterceptorKey name;

        /**
         * 顺序
         */
        @NotNull
        private Integer order;
    }

    public LoadConfig getByInterceptorKey(String key) {
        return load.stream().filter(loadConfig -> loadConfig.name.equals(key))
                .findFirst().orElse(null);

    }


}

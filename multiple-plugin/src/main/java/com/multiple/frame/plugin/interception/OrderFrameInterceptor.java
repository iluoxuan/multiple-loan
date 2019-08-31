package com.multiple.frame.plugin.interception;

import com.multiple.frame.common.support.FrameInterceptor;
import com.multiple.frame.plugin.config.PluginProperties;
import lombok.Setter;
import org.springframework.core.Ordered;
import org.springframework.util.Assert;

/**
 * @author: junqing.li
 * @date: 2019/8/31
 */
@Setter
public abstract class OrderFrameInterceptor implements FrameInterceptor, Ordered {

    protected PluginProperties pluginProperties;

    @Override
    public int getOrder() {
        PluginProperties.LoadConfig loadConfig = pluginProperties.getByInterceptorKey(nameKey().name());
        Assert.notNull(loadConfig, "please yml config plugin");
        return loadConfig.getOrder();
    }
}

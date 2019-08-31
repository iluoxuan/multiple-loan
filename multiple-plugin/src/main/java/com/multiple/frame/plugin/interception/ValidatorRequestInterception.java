package com.multiple.frame.plugin.interception;

import com.multiple.frame.common.support.FrameInterceptor;
import com.multiple.frame.common.support.InterceptorKey;
import com.multiple.frame.plugin.common.PluginInterceptorKey;
import com.multiple.frame.plugin.config.PluginProperties;
import lombok.Setter;
import org.springframework.core.Ordered;

/**
 * @author: junqing.li
 * @date: 2019/8/31
 */
@Setter
public class ValidatorRequestInterception implements FrameInterceptor, Ordered {

    private PluginProperties pluginProperties;


    @Override
    public int getOrder() {
        return pluginProperties.getByInterceptorKey(nameKey().name()).getOrder();
    }

    @Override
    public InterceptorKey nameKey() {
        return PluginInterceptorKey.validator;
    }
}

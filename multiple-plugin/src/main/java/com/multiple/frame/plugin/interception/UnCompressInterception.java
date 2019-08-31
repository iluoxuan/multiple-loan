package com.multiple.frame.plugin.interception;

import com.multiple.frame.common.base.ChannelExchange;
import com.multiple.frame.common.support.FrameInterceptor;
import com.multiple.frame.common.support.InterceptorKey;
import com.multiple.frame.plugin.common.PluginInterceptorKey;

/**
 * 解压 插件
 *
 * @author: junqing.li
 * @date: 2019/8/29
 */
public class UnCompressInterception extends OrderFrameInterceptor {

    @Override
    public InterceptorKey nameKey() {
        return PluginInterceptorKey.unCompress;
    }

    @Override
    public boolean preHandle(ChannelExchange exchange) throws Exception {
        return true;
    }
}

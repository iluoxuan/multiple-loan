package com.multiple.frame.plugin;

import com.multiple.frame.common.base.ChannelExchange;
import com.multiple.frame.common.support.GlobalInterceptor;

/**
 * 解压 插件
 *
 * @author: junqing.li
 * @date: 2019/8/29
 */
public class UnCompressBizInterception implements GlobalInterceptor {

    @Override
    public boolean preHandle(ChannelExchange exchange) throws Exception {
        return true;
    }
}

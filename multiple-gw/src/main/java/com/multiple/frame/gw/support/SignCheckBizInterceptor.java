package com.multiple.frame.gw.support;

import com.multiple.frame.common.base.ChannelExchange;
import com.multiple.frame.sign.config.SignProperties;
import com.multiple.frame.sign.support.AbstractSignCheckBizInterceptor;
import com.multiple.frame.sign.support.SignConfig;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author: junqing.li
 * @date: 2019/8/29
 */
//@Order
//@Component
public class SignCheckBizInterceptor extends AbstractSignCheckBizInterceptor {

    @Override
    protected SignConfig createSignConfig(ChannelExchange exchange, SignProperties signProperties) {

        return null;
    }
}

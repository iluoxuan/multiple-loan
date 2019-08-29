package com.multiple.frame.core.handler.method;

import com.multiple.frame.common.base.ChannelExchange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

/**
 * @author: junqing.li
 * @date: 2019/7/31
 */
@Slf4j
public abstract class AbstractMethodMapping implements MethodMapping {

    @Autowired
    protected ApplicationContext applicationContext;

    @Override
    public void look(ChannelExchange exchange) {

        look0(exchange);

    }

    /**
     * 找到 mapping 处理方式
     *
     * @param exchange 拦截器 exchange
     */
    protected abstract void look0(ChannelExchange exchange);


}

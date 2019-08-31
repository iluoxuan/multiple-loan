package com.multiple.frame.gw.support;

import com.multiple.frame.common.base.ChannelExchange;
import com.multiple.frame.common.support.FrameInterceptor;
import com.multiple.frame.common.support.InterceptorKey;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author: junqing.li
 * @date: 2019/8/29
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
@Slf4j
public class TestFrameInterceptor implements FrameInterceptor {

    @Override
    public boolean preHandle(ChannelExchange exchange) throws Exception {


        // fix
        log.info("[preHandle] -----  test frame --- in");

        return true;
    }

    @Override
    public InterceptorKey nameKey() {
        return GwInterceptorKey.testFrame;
    }
}

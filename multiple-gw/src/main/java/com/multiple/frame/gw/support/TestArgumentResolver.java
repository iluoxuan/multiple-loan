package com.multiple.frame.gw.support;

import com.multiple.frame.common.support.ArgumentResolver;
import com.multiple.frame.common.base.ChannelExchange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: junqing.li
 * @date: 2019/8/29
 */
@Component
@Slf4j
public class TestArgumentResolver implements ArgumentResolver {

    @Override
    public boolean supportsParameter(ChannelExchange exchange) {
        return true;
    }

    @Override
    public void resolveArgument(ChannelExchange exchange) {

        log.info("resolveArgument ----  test ");
    }
}

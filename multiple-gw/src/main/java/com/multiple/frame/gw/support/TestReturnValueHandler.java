package com.multiple.frame.gw.support;

import com.multiple.frame.common.base.ChannelExchange;
import com.multiple.frame.common.support.ReturnValueHandler;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author: junqing.li
 * @date: 2019/8/29
 */
@Component
@Slf4j
public class TestReturnValueHandler implements ReturnValueHandler {

    @Override
    public boolean supports(ChannelExchange exchange) {
        return true;
    }

    @Override
    public void handleReturnValue(ChannelExchange exchange) {

        log.info("handleReturnValue --- test");

    }
}

package com.multiple.frame.gw.support;

import com.multiple.frame.common.base.ChannelExchange;
import com.multiple.frame.common.support.ExceptionHandler;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.stereotype.Component;

/**
 * @author: junqing.li
 * @date: 2019/9/4
 */
@Component
@Slf4j
public class DefaultExceptionHandler implements ExceptionHandler {

    @Override
    public void handlerException(ChannelExchange exchange, Exception e) {

        log.info("[handlerException] error={}", ExceptionUtils.getStackTrace(e));
    }
}

package com.multiple.frame.gw.support;


import com.multiple.frame.common.base.ChannelExchange;
import com.multiple.frame.common.support.ExceptionHandler;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: junqing.li
 * @date: 2019/8/29
 */
@Slf4j
public class TestHandlerException implements ExceptionHandler {


    @Override
    public void handlerException(ChannelExchange exchange, Exception e) {

        log.info("[handlerException] -----");
    }
}

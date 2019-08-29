package com.multiple.frame.core.support;

import com.multiple.frame.common.base.ChannelExchange;
import com.multiple.frame.common.support.ExceptionHandler;
import lombok.Setter;
import org.assertj.core.util.Lists;

import java.util.List;

/**
 * @author: junqing.li
 * @date: 2019/8/29
 */
public class ExceptionHandlerComposite implements ExceptionHandler {

    private List<ExceptionHandler> exceptionHandlerList = Lists.newArrayList();

    @Override
    public void handlerException(ChannelExchange exchange, Exception e) {

        exceptionHandlerList.stream()
                .forEach(exceptionHandler -> exceptionHandler.handlerException(exchange, e));
    }

    public void addExceptionHandlers(List<ExceptionHandler> exceptionHandlers) {
        exceptionHandlerList.addAll(exceptionHandlers);
    }
}

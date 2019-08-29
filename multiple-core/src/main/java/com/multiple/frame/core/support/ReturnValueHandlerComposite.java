package com.multiple.frame.core.support;

import com.multiple.frame.common.base.ChannelExchange;
import com.multiple.frame.common.support.ReturnValueHandler;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;

import java.util.List;
import java.util.Optional;

/**
 * @author: junqing.li
 * @date: 2019/8/29
 */
@Setter
@Slf4j
public class ReturnValueHandlerComposite implements ReturnValueHandler {

    private List<ReturnValueHandler> returnValueHandlerList = Lists.newArrayList();

    @Override
    public boolean supports(ChannelExchange exchange) {
        return getReturnValueHandler(exchange).isPresent();
    }

    @Override
    public void handleReturnValue(ChannelExchange exchange) {

        Optional<ReturnValueHandler> optional = getReturnValueHandler(exchange);
        if (!optional.isPresent()) {
            return;
        }

        optional.get().handleReturnValue(exchange);

    }


    private Optional<ReturnValueHandler> getReturnValueHandler(ChannelExchange exchange) {

        return returnValueHandlerList.stream()
                .filter(returnValueHandler -> returnValueHandler.supports(exchange))
                .findFirst();
    }

    public void addReturnValueHandler(List<ReturnValueHandler> returnValueHandlers) {

        returnValueHandlerList.addAll(returnValueHandlers);
    }
}

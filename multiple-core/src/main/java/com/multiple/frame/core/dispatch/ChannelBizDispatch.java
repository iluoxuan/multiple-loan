package com.multiple.frame.core.dispatch;

import com.multiple.frame.common.support.ChannelBizInterceptor;
import com.multiple.frame.common.base.ChannelExchange;
import com.multiple.frame.common.base.ChannelParam;
import com.multiple.frame.common.base.LocalContext;
import com.multiple.frame.common.exception.ChannelException;
import com.multiple.frame.core.interceptor.ChannelHandlerExecutionChain;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.List;

/**
 * 渠道处理器
 *
 * @author: junqing.li
 * @date: 2019/8/27
 */
@Slf4j
@Setter
@Getter
public class ChannelBizDispatch implements BizDispatch {

    private List<ChannelBizInterceptor> channelInterceptors;


    /**
     * dispatch --
     *
     * @param param
     * @return
     */
    @Override
    public Object doDispatch(ChannelParam param) {

        ChannelExchange exchange = new ChannelExchange();
        exchange.setChannelParam(param);
        ChannelHandlerExecutionChain executionChain = getExecuteChain();

        LocalContext localContext = LocalContext.getCurrentContext();

        try {

            Exception exception = null;

            try {

                if (!executionChain.applyPreHandle(exchange)) {
                    throw new ChannelException("execute chain fail");
                }

                executionChain.applyPostHandle(exchange);

            } catch (Exception ex) {

                exception = ex;
            }
            processException(executionChain, exchange, exception);

        } finally {

            localContext.unset();
        }

        return exchange.getResponse();

    }

    private void processException(ChannelHandlerExecutionChain executionChain, ChannelExchange exchange, Exception exception) {

        log.error("[processException] error={}", ExceptionUtils.getStackTrace(exception));


    }

    private ChannelHandlerExecutionChain getExecuteChain() {

        return new ChannelHandlerExecutionChain(channelInterceptors);
    }

}


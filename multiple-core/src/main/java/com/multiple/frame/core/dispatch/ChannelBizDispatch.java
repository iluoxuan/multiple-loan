package com.multiple.frame.core.dispatch;

import com.multiple.frame.common.base.ChannelExchange;
import com.multiple.frame.common.base.ChannelParam;
import com.multiple.frame.common.base.LocalContext;
import com.multiple.frame.common.exception.ChannelException;
import com.multiple.frame.common.support.Interceptor;
import com.multiple.frame.core.config.MultipleFrameProperties;
import com.multiple.frame.core.interceptor.ChannelHandlerExecutionChain;
import com.multiple.frame.core.support.ExceptionHandlerComposite;
import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;

import java.util.List;
import java.util.Objects;

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

    private List<Interceptor> interceptors;

    private ExceptionHandlerComposite exceptionHandlerComposite;

    private MultipleFrameProperties multipleFrameProperties;


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
        ChannelHandlerExecutionChain executionChain = getExecuteChain(exchange);

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

    private void processException(ChannelHandlerExecutionChain executionChain, ChannelExchange exchange, Exception e) {


        Exception ex = e;

        try {
            executionChain.triggerAfterCompletion(exchange, e);
        } catch (Exception e1) {

            log.error("[processException] ex={}", ExceptionUtils.getStackTrace(e));
            ex = e1;
        }

        if (Objects.isNull(ex)) {
            return;
        }

        exceptionHandlerComposite.handlerException(exchange, ex);

    }

    private ChannelHandlerExecutionChain getExecuteChain(ChannelExchange exchange) {

        return new ChannelHandlerExecutionChain(interceptors,
                multipleFrameProperties.getByChannel(exchange.getChannelParam().getChannelCode()));
    }

}


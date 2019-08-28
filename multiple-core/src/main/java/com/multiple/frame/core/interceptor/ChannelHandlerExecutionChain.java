package com.multiple.frame.core.interceptor;

import com.multiple.frame.common.base.ChannelBizInterceptor;
import com.multiple.frame.common.base.ChannelExchange;
import lombok.extern.slf4j.Slf4j;
import org.springframework.util.ObjectUtils;

import java.util.List;

/**
 * 原型对象 需要计算下标
 *
 * @author: junqing.li
 * @date: 2019/7/19
 */
@Slf4j
public class ChannelHandlerExecutionChain {


    private List<ChannelBizInterceptor> interceptorList;

    /**
     * 拦截器 先执行的 最后执行 触发
     */
    private int interceptorIndex = -1;


    public ChannelHandlerExecutionChain(List<ChannelBizInterceptor> interceptorList) {
        this.interceptorList = interceptorList;
    }

    /**
     * Apply preHandle methods of registered interceptors.
     *
     * @return {@code true} if the execution chain should proceed with the next interceptor or the handler itself. Else,
     * DispatcherServlet assumes that this interceptor has already dealt with the response itself.
     */
    public boolean applyPreHandle(ChannelExchange exchange) throws Exception {
        ChannelBizInterceptor[] interceptors = getInterceptors();
        if (!ObjectUtils.isEmpty(interceptors)) {
            for (int i = 0; i < interceptors.length; i++) {
                ChannelBizInterceptor interceptor = interceptors[i];
                if (!interceptor.preHandle(exchange)) {
                    triggerAfterCompletion(exchange, null);
                    return false;
                }
                this.interceptorIndex = i;
            }
        }
        return true;
    }

    private ChannelBizInterceptor[] getInterceptors() {
        return this.interceptorList.toArray(new ChannelBizInterceptor[this.interceptorList.size()]);
    }

    /**
     * Apply postHandle methods of registered interceptors.
     */
    public void applyPostHandle(ChannelExchange exchange) throws Exception {
        ChannelBizInterceptor[] interceptors = getInterceptors();
        if (!ObjectUtils.isEmpty(interceptors)) {
            for (int i = interceptors.length - 1; i >= 0; i--) {
                ChannelBizInterceptor interceptor = interceptors[i];
                interceptor.postHandle(exchange);
            }
        }
    }

    /**
     * Trigger afterCompletion callbacks on the mapped HandlerInterceptors. Will just invoke afterCompletion for all
     * interceptors whose preHandle invocation has successfully completed and returned true.
     */
    public void triggerAfterCompletion(ChannelExchange exchange, Throwable ex)
            throws Exception {

        ChannelBizInterceptor[] interceptors = getInterceptors();
        if (!ObjectUtils.isEmpty(interceptors)) {
            for (int i = this.interceptorIndex; i >= 0; i--) {
                ChannelBizInterceptor interceptor = interceptors[i];
                try {
                    interceptor.afterCompletion(exchange, ex);
                } catch (Throwable ex2) {
                    log.error("HandlerInterceptor.afterCompletion threw exception", ex2);
                }
            }
        }
    }

    public void addInterceptor(ChannelBizInterceptor interceptor) {
        interceptorList.add(interceptor);
    }


}

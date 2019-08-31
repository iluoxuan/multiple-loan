package com.multiple.frame.core.interceptor;

import com.multiple.frame.common.base.ChannelExchange;
import com.multiple.frame.common.support.FrameInterceptor;
import com.multiple.frame.common.support.GlobalInterceptor;
import com.multiple.frame.common.support.Interceptor;
import lombok.extern.slf4j.Slf4j;
import org.assertj.core.util.Lists;
import org.springframework.util.Assert;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Set;

/**
 * 原型对象 需要计算下标
 *
 * @author: junqing.li
 * @date: 2019/7/19
 */
@Slf4j
public class ChannelHandlerExecutionChain {


    private List<Interceptor> interceptorList = Lists.newArrayList();

    /**
     * 拦截器 先执行的 最后执行 触发
     */
    private int interceptorIndex = -1;


    public ChannelHandlerExecutionChain(List<Interceptor> interceptorList, Set<String> interceptorKeys) {

        Assert.notNull(interceptorKeys, "interceptor config keys is null");

        // TODO 需要在拦截器初始化之前
        for (Interceptor interceptor : interceptorList) {

            if (interceptor instanceof GlobalInterceptor) {
                this.interceptorList.add(interceptor);
                continue;
            }

            FrameInterceptor frameInterceptor = (FrameInterceptor) interceptor;
            if (interceptorKeys.contains(frameInterceptor.nameKey().name())) {
                this.interceptorList.add(interceptor);
            }
        }


    }


    /**
     * Apply preHandle methods of registered interceptors.
     *
     * @return {@code true} if the execution chain should proceed with the next interceptor or the handler itself. Else,
     * DispatcherServlet assumes that this interceptor has already dealt with the response itself.
     */
    public boolean applyPreHandle(ChannelExchange exchange) throws Exception {
        Interceptor[] interceptors = getInterceptors();
        if (!ObjectUtils.isEmpty(interceptors)) {
            for (int i = 0; i < interceptors.length; i++) {
                Interceptor interceptor = interceptors[i];
                if (!interceptor.preHandle(exchange)) {
                    triggerAfterCompletion(exchange, null);
                    return false;
                }
                this.interceptorIndex = i;
            }
        }
        return true;
    }

    private Interceptor[] getInterceptors() {
        return this.interceptorList.toArray(new Interceptor[this.interceptorList.size()]);
    }

    /**
     * Apply postHandle methods of registered interceptors.
     */
    public void applyPostHandle(ChannelExchange exchange) throws Exception {
        Interceptor[] interceptors = getInterceptors();
        if (!ObjectUtils.isEmpty(interceptors)) {
            for (int i = interceptors.length - 1; i >= 0; i--) {
                Interceptor interceptor = interceptors[i];
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

        Interceptor[] interceptors = getInterceptors();
        if (!ObjectUtils.isEmpty(interceptors)) {
            for (int i = this.interceptorIndex; i >= 0; i--) {
                Interceptor interceptor = interceptors[i];
                try {
                    interceptor.afterCompletion(exchange, ex);
                } catch (Throwable ex2) {
                    log.error("HandlerInterceptor.afterCompletion threw exception", ex2);
                }
            }
        }
    }

    public void addInterceptor(Interceptor interceptor) {
        interceptorList.add(interceptor);
    }


}

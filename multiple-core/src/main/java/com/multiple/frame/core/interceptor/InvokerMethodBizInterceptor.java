package com.multiple.frame.core.interceptor;

import com.multiple.frame.common.base.BizInterceptorOrder;
import com.multiple.frame.common.base.ChannelExchange;
import com.multiple.frame.common.base.ExecuteInfo;
import com.multiple.frame.common.support.GlobalInterceptor;
import com.multiple.frame.swak.entity.ExecuteType;
import com.multiple.frame.swak.entity.MethodExecuteInfo;
import com.multiple.frame.swak.entity.SwakLocal;
import org.springframework.core.Ordered;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

import java.util.Objects;

/**
 * @author: junqing.li
 * @date: 2019/8/27
 */
public class InvokerMethodBizInterceptor implements GlobalInterceptor, Ordered {

    @Override
    public void postHandle(ChannelExchange exchange) throws Exception {


        // 使用swak执行
        MethodExecuteInfo methodExecuteInfo = exchange.getAttribute("swak");
        if (Objects.nonNull(methodExecuteInfo)) {

            SwakLocal.getCurrent().getContext().setExecuteType(ExecuteType.methodNameInvoke);
            Object response = ReflectionUtils.invokeMethod(methodExecuteInfo.getMethod(),
                    methodExecuteInfo.getTarget());
            exchange.setResponse(response);
            return;
        }

        ExecuteInfo executeInfo = exchange.getExecuteInfo();
        Assert.notNull(executeInfo, "no find execute");

        // 执行的结果
        Object response = ReflectionUtils.invokeMethod(executeInfo.getMethod(), executeInfo.getBean());

        exchange.setResponse(response);

    }

    @Override
    public int getOrder() {
        return BizInterceptorOrder.invokerMethod;
    }
}

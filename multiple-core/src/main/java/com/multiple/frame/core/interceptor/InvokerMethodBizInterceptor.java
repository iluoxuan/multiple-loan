package com.multiple.frame.core.interceptor;

import com.multiple.frame.common.base.ChannelBizInterceptor;
import com.multiple.frame.common.base.ChannelExchange;
import com.multiple.frame.common.base.ExecuteInfo;
import org.springframework.util.Assert;
import org.springframework.util.ReflectionUtils;

/**
 * @author: junqing.li
 * @date: 2019/8/27
 */
public class InvokerMethodBizInterceptor implements ChannelBizInterceptor {

    @Override
    public void postHandle(ChannelExchange exchange) throws Exception {

        ExecuteInfo executeInfo = exchange.getExecuteInfo();
        Assert.notNull(executeInfo, "no find execute");

        // 执行的结果
        Object response = ReflectionUtils.invokeMethod(executeInfo.getMethod(), executeInfo.getChannelInfo());

        exchange.setResponse(response);

    }
}

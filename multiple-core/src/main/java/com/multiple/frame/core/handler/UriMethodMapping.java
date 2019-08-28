package com.multiple.frame.core.handler;

import com.multiple.frame.common.base.ChannelExchange;
import com.multiple.frame.common.base.ChannelInfo;
import com.multiple.frame.common.base.ChannelParam;
import com.multiple.frame.common.base.ExecuteInfo;
import com.multiple.frame.common.utils.ReflectUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Map;
import java.util.Optional;

/**
 * @author: junqing.li
 * @date: 2019/8/27
 */
@Order(-100)
@Component
public class UriMethodMapping extends AbstractMethodMapping {

    @Override
    public boolean support(ChannelExchange exchange) {

        if (ExecuteInfo.isNull(exchange.getExecuteInfo())) {
            return true;
        }

        return !exchange.getChannelParam().isBodyMethod();
    }

    @Override
    protected void look0(ChannelExchange exchange) {

        ChannelParam channelParam = exchange.getChannelParam();
        // 找到有对应处理器的

        ChannelInfo currentBean = getExecuteBean(channelParam.getChannelCode());
        Method method = ReflectUtils.getDeclaredMethod(currentBean, channelParam.getBizMethod());
        exchange.setExecuteInfo(new ExecuteInfo(method, currentBean));

    }


    /**
     * 找到对应的处理器 没有找到抛出异常
     */
    private ChannelInfo getExecuteBean(String channelCode) {

        Map<String, ? extends ChannelInfo> beans = applicationContext.getBeansOfType(ChannelInfo.class);

        // 先过滤再map
        Optional<ChannelInfo> currentBean = beans.entrySet().stream().filter(entry -> {

            ChannelInfo channelInfo = entry.getValue();
            return channelCode.equals(channelInfo.code());

        }).map(entry -> (ChannelInfo) entry.getValue()).findFirst();

        return currentBean.orElse(null);

    }
}

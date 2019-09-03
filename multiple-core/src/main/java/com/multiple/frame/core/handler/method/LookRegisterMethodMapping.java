package com.multiple.frame.core.handler.method;

import com.multiple.frame.common.base.BizFunctionConfig;
import com.multiple.frame.common.base.ChannelExchange;
import com.multiple.frame.common.base.ChannelParam;
import com.multiple.frame.common.base.ExecuteInfo;
import com.multiple.frame.core.register.ExecuteRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author: junqing.li
 * @date: 2019/9/3
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class LookRegisterMethodMapping extends AbstractMethodMapping {

    @Autowired
    private ExecuteRegister executeRegister;

    @Override
    protected void look0(ChannelExchange exchange) {

        ChannelParam param = exchange.getChannelParam();
        BizFunctionConfig config = exchange.getBizFunctionConfig();
        ExecuteInfo executeInfo = executeRegister.lookUp(param.getChannelCode(),
                param.getBizMethod(), config.getBizUnit());
        exchange.setExecuteInfo(executeInfo);

    }

    @Override
    public boolean support(ChannelExchange exchange) {
        return ExecuteInfo.isNull(exchange.getExecuteInfo());
    }
}

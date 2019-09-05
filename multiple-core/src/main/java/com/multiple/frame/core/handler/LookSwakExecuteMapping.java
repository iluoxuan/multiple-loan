package com.multiple.frame.core.handler;

import com.multiple.frame.common.base.BizFunctionConfig;
import com.multiple.frame.common.base.ChannelExchange;
import com.multiple.frame.common.base.ChannelParam;
import com.multiple.frame.swak.entity.MethodExecuteInfo;
import com.multiple.frame.swak.entity.SwakContext;
import com.multiple.frame.swak.register.SwakRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author: junqing.li
 * @date: 2019/9/5
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class LookSwakExecuteMapping extends AbstractMethodMapping {

    @Autowired
    private SwakRegister swakRegister;

    @Override
    protected void look0(ChannelExchange exchange) {

        ChannelParam param = exchange.getChannelParam();
        BizFunctionConfig config = exchange.getBizFunctionConfig();
        SwakContext swakContext = new SwakContext();
        swakContext.setBizCode(param.getChannelCode());
        swakContext.setTags(config.getBizUnit());
        MethodExecuteInfo methodExecuteInfo = swakRegister.lookMethod(swakContext, param.getBizMethod());
        //
        exchange.getAttributes().put("swak", methodExecuteInfo);


    }

    @Override
    public boolean support(ChannelExchange exchange) {
        return true;
    }
}

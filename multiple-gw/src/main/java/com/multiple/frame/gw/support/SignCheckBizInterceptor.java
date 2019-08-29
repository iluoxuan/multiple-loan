package com.multiple.frame.gw.support;

import com.multiple.frame.common.base.BaseRequest;
import com.multiple.frame.common.base.ChannelExchange;
import com.multiple.frame.parser.interceptor.RequestCommonParserInterceptor;
import com.multiple.frame.parser.parser.common.RequestCommonTemplate;
import com.multiple.frame.sign.config.SignProperties;
import com.multiple.frame.sign.support.AbstractSignCheckBizInterceptor;
import com.multiple.frame.sign.support.SignConfig;
import com.multiple.frame.sign.support.SignContext;
import org.springframework.beans.BeanUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

/**
 * @author: junqing.li
 * @date: 2019/8/29
 */
@Order(-950)
@Component
public class SignCheckBizInterceptor extends AbstractSignCheckBizInterceptor {

    @Override
    protected SignContext createSignContext(ChannelExchange exchange, SignProperties signProperties) {

        RequestCommonTemplate template = exchange.getAttribute(RequestCommonParserInterceptor.requestParserData);
        Assert.notNull(template, "no find request parser template");


        SignConfig signConfig = new SignConfig();
        signConfig.setPrivateKey(signProperties.getPrivateKey());
        signConfig.setChannelPublicKey("xxxxxxx");
        signConfig.setEncrypt("ase");
        signConfig.setRule("ascAnd");
        signConfig.setExclude("sign");

        //

        return null;
    }
}

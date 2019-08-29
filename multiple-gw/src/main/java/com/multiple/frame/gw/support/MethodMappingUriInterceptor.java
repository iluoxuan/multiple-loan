package com.multiple.frame.gw.support;

import com.multiple.frame.common.base.ChannelExchange;
import com.multiple.frame.common.support.FrameInterceptor;
import com.multiple.frame.parser.interceptor.RequestCommonParserInterceptor;
import com.multiple.frame.parser.parser.common.RequestCommonTemplate;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

/**
 * method 映射 uri
 *
 * @author: junqing.li
 * @date: 2019/8/29
 */
public class MethodMappingUriInterceptor implements FrameInterceptor {

    @Autowired
    private Environment environment;

    @Override
    public boolean preHandle(ChannelExchange exchange) throws Exception {

        RequestCommonTemplate template = exchange.getAttribute(RequestCommonParserInterceptor.requestParserData);
        String method = template.getMethod();
        if(StringUtils.isBlank(method)){
            return true;
        }

        // TODO 取配置文件中的映射


        return true;
    }

    @Override
    public String nameKey() {
        return "methodMappingUri";
    }
}

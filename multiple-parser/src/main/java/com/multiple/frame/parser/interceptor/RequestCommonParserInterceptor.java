package com.multiple.frame.parser.interceptor;

import com.multiple.frame.common.base.ChannelExchange;
import com.multiple.frame.common.support.GlobalInterceptor;
import com.multiple.frame.parser.config.ParserProperties;
import com.multiple.frame.parser.parser.RequestCommonParser;
import com.multiple.frame.parser.parser.common.RequestCommonTemplate;
import com.multiple.frame.parser.resouce.ResourceManager;
import com.multiple.frame.parser.resouce.TemplateResource;
import lombok.Setter;

/**
 * 请求 模板解析
 *
 * @author: junqing.li
 * @date: 2019/8/28
 */
@Setter
public class RequestCommonParserInterceptor implements GlobalInterceptor {

    public final static String requestParserData = "requestParserData";

    private RequestCommonParser requestCommonParser;

    private ResourceManager resourceManager;

    private ParserProperties parserProperties;

    @Override
    public boolean preHandle(ChannelExchange exchange) throws Exception {

        TemplateResource resource = resourceManager.getResource(parserProperties.getTemplatePath(), parserProperties.getResourceLoaderType());
        RequestCommonTemplate template = requestCommonParser.parser(resource.getData());

        exchange.getAttributes().put(requestParserData, template);

        return true;
    }
}

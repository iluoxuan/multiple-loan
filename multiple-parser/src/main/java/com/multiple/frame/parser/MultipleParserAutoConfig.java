package com.multiple.frame.parser;

import com.multiple.frame.common.base.BizInterceptorOrder;
import com.multiple.frame.common.support.GlobalInterceptor;
import com.multiple.frame.parser.config.ParserProperties;
import com.multiple.frame.parser.interceptor.RequestCommonParserInterceptor;
import com.multiple.frame.parser.parser.RequestCommonParser;
import com.multiple.frame.parser.resouce.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

/**
 * @author: junqing.li
 * @date: 2019/8/28
 */
@ComponentScan
@EnableAutoConfiguration
@EnableConfigurationProperties(ParserProperties.class)
@Configuration
public class MultipleParserAutoConfig {

    @Autowired
    ParserProperties parserProperties;

    @Bean
    @ConditionalOnMissingBean
    public ResourceCache resourceCache() {

        return new MapCache();
    }


    @Bean
    @ConditionalOnMissingBean
    public ResourceManager resourceManager(List<ResourceLoader> resourceLoaders) {
        TemplateResourceManager resourceManager = new TemplateResourceManager();

        resourceManager.setResourceCache(resourceCache());
        resourceManager.setParserProperties(parserProperties);
        resourceManager.setResourceLoaderList(resourceLoaders);
        return resourceManager;
    }

    @Bean
    @ConditionalOnMissingBean(name = "requestCommonParser")
    public RequestCommonParser requestCommonParser() {
        RequestCommonParser parser = new RequestCommonParser();
        return parser;
    }


    @Order(BizInterceptorOrder.requestParser)
    @Bean
    @ConditionalOnMissingBean(name = "requestCommonParserInterceptor")
    public GlobalInterceptor requestCommonParserInterceptor(RequestCommonParser requestCommonParser,
                                                            List<ResourceLoader> resourceLoaders) {

        RequestCommonParserInterceptor interceptor = new RequestCommonParserInterceptor();
        interceptor.setParserProperties(parserProperties);
        interceptor.setRequestCommonParser(requestCommonParser);
        interceptor.setResourceManager(resourceManager(resourceLoaders));
        return interceptor;
    }


}

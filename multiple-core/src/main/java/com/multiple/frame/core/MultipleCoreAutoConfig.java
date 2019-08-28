package com.multiple.frame.core;

import com.multiple.frame.common.base.BizInterceptorOrder;
import com.multiple.frame.common.base.ChannelBizInterceptor;
import com.multiple.frame.core.dispatch.BizDispatch;
import com.multiple.frame.core.dispatch.ChannelBizDispatch;
import com.multiple.frame.core.config.MultipleLoanProperties;
import com.multiple.frame.core.handler.MethodMappingManager;
import com.multiple.frame.core.interceptor.InvokerMethodBizInterceptor;
import com.multiple.frame.core.interceptor.LookExecuteBizInterceptor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

import java.util.List;

/**
 * 自动加载
 *
 * @author: junqing.li
 * @date: 2019/8/27
 */
@ComponentScan
@EnableConfigurationProperties(MultipleLoanProperties.class)
@Configuration
public class MultipleCoreAutoConfig {


    @Bean
    public MethodMappingManager methodMappingManager() {
        return new MethodMappingManager();
    }

    @Order(BizInterceptorOrder.invokerMethod)
    @Bean
    @ConditionalOnMissingBean(name = "invokerMethodBizInterceptor")
    public ChannelBizInterceptor invokerMethodBizInterceptor() {
        return new InvokerMethodBizInterceptor();
    }

    @Order(BizInterceptorOrder.lookExecute)
    @Bean
    @ConditionalOnMissingBean(name = "lookExecuteBizInterceptor")
    public ChannelBizInterceptor lookExecuteBizInterceptor(MethodMappingManager methodMappingManager) {
        LookExecuteBizInterceptor interceptor = new LookExecuteBizInterceptor();
        interceptor.setMethodMappingManager(methodMappingManager);
        return interceptor;
    }


    @Bean
    @ConditionalOnMissingBean
    public BizDispatch bizDispatch(List<ChannelBizInterceptor> channelBizInterceptorList) {
        ChannelBizDispatch dispatch = new ChannelBizDispatch();
        dispatch.setChannelInterceptors(channelBizInterceptorList);
        return dispatch;
    }

}

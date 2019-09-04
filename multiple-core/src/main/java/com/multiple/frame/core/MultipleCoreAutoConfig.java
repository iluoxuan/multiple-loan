package com.multiple.frame.core;

import com.multiple.frame.common.support.*;
import com.multiple.frame.core.config.MultipleFrameProperties;
import com.multiple.frame.core.dispatch.BizDispatch;
import com.multiple.frame.core.dispatch.ChannelBizDispatch;
import com.multiple.frame.core.endpoint.FrameEndpoint;
import com.multiple.frame.core.handler.method.MethodMappingManager;
import com.multiple.frame.core.interceptor.InvokerMethodBizInterceptor;
import com.multiple.frame.core.interceptor.LookExecuteBizInterceptor;
import com.multiple.frame.core.interceptor.RequestResolverBizInterceptor;
import com.multiple.frame.core.interceptor.ReturnValueBizInterceptor;
import com.multiple.frame.core.register.DefaultExecuteRegister;
import com.multiple.frame.core.register.ExecuteRegister;
import com.multiple.frame.core.register.FrameInit;
import com.multiple.frame.core.support.ArgumentResolverComposite;
import com.multiple.frame.core.support.ExceptionHandlerComposite;
import com.multiple.frame.core.support.ReturnValueHandlerComposite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.autoconfigure.endpoint.condition.ConditionalOnEnabledEndpoint;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * 自动加载
 *
 * @author: junqing.li
 * @date: 2019/8/27
 */
@ComponentScan
@EnableConfigurationProperties(MultipleFrameProperties.class)
@Configuration
public class MultipleCoreAutoConfig {

    @Autowired
    private ApplicationContext applicationContext;

    @Autowired
    private MultipleFrameProperties multipleFrameProperties;


    @Bean
    public MethodMappingManager methodMappingManager() {
        return new MethodMappingManager();
    }

    @Bean
    @ConditionalOnMissingBean(name = "invokerMethodBizInterceptor")
    public GlobalInterceptor invokerMethodBizInterceptor() {
        return new InvokerMethodBizInterceptor();
    }

    @Bean
    @ConditionalOnMissingBean(name = "lookExecuteBizInterceptor")
    public GlobalInterceptor lookExecuteBizInterceptor(MethodMappingManager methodMappingManager) {
        LookExecuteBizInterceptor interceptor = new LookExecuteBizInterceptor();
        interceptor.setMethodMappingManager(methodMappingManager);
        return interceptor;
    }


    @Bean
    @ConditionalOnMissingBean(name = "requestResolverBizInterceptor")
    public GlobalInterceptor requestResolverBizInterceptor(List<ArgumentResolver> argumentResolvers) {
        RequestResolverBizInterceptor interceptor = new RequestResolverBizInterceptor();
        ArgumentResolverComposite composite = new ArgumentResolverComposite();
        composite.addArgumentResolver(argumentResolvers);
        interceptor.setArgumentResolverComposite(composite);
        return interceptor;
    }

    @Bean
    @ConditionalOnMissingBean(name = "returnValueBizInterceptor")
    public GlobalInterceptor returnValueBizInterceptor(List<ReturnValueHandler> returnValueHandlers) {
        ReturnValueBizInterceptor interceptor = new ReturnValueBizInterceptor();
        ReturnValueHandlerComposite composite = new ReturnValueHandlerComposite();
        composite.addReturnValueHandler(returnValueHandlers);
        interceptor.setReturnValueHandlerComposite(composite);
        return interceptor;
    }

    @Bean
    @ConditionalOnMissingBean(name = "exceptionHandlerComposite")
    public ExceptionHandlerComposite exceptionHandlerComposite(List<ExceptionHandler> exceptionHandlers) {

        ExceptionHandlerComposite composite = new ExceptionHandlerComposite();
        composite.addExceptionHandlers(exceptionHandlers);
        return composite;
    }


    @Bean
    @ConditionalOnMissingBean
    public BizDispatch bizDispatch(List<Interceptor> interceptors,
                                   ExceptionHandlerComposite exceptionHandlerComposite) {
        ChannelBizDispatch dispatch = new ChannelBizDispatch();
        dispatch.setInterceptors(interceptors);
        dispatch.setExceptionHandlerComposite(exceptionHandlerComposite);
        dispatch.setMultipleFrameProperties(multipleFrameProperties);
        return dispatch;
    }

    @Bean(initMethod = "init", destroyMethod = "destroy")
    public FrameInit frameInit(ExecuteRegister executeRegister) {
        FrameInit init = new FrameInit();
        init.setApplicationContext(applicationContext);
        init.setExecuteRegister(executeRegister);
        return init;
    }

    @Bean
    public ExecuteRegister executeRegister() {

        return new DefaultExecuteRegister();
    }


    /**
     * 端点配置
     */
    @Configuration
    static class EndpointConfiguration {

        @Bean
        @ConditionalOnMissingBean
        @ConditionalOnEnabledEndpoint
        public FrameEndpoint frameEndpoint() {
            return new FrameEndpoint();
        }
    }


}

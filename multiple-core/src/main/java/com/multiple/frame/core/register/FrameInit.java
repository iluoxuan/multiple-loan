package com.multiple.frame.core.register;

import com.multiple.frame.common.base.*;
import com.multiple.frame.common.exception.ChannelException;
import lombok.Setter;
import org.apache.commons.lang3.StringUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.Assert;
import org.springframework.util.CollectionUtils;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Map;
import java.util.Objects;

/**
 * 初始化 channel -> 方法
 * 初始化 channel, unit  -> 方法
 *
 * @author: junqing.li
 * @date: 2019/9/3
 */
public class FrameInit {

    @Setter
    private ExecuteRegister executeRegister;

    @Setter
    private ApplicationContext applicationContext;


    public void init() {

        initExecuteInfo();

    }

    private void initExecuteInfo() {

        // 扫描所有多实现接口和类
        Map<String, Object> frameMap = applicationContext.getBeansWithAnnotation(FrameBiz.class);
        Map<String, ChannelInfo> frameChannelInfo = applicationContext.getBeansOfType(ChannelInfo.class);
        frameMap.putAll(frameChannelInfo);

        if (CollectionUtils.isEmpty(frameMap)) {
            return;
        }

        frameMap.entrySet().forEach(entry -> {
            Object beanObject = entry.getValue();
            FrameBiz frameBiz = AnnotationUtils.findAnnotation(beanObject.getClass(), FrameBiz.class);
            // 初始化所有的方法

            Method[] methods = beanObject.getClass().getDeclaredMethods();
            Arrays.stream(methods).forEach(method -> {

                ExecuteInfo executeInfo = new ExecuteInfo();
                executeInfo.setBean(beanObject);
                executeInfo.setChannel(getChannel(beanObject, frameBiz));
                executeInfo.setMethod(method);
                executeInfo.setUnitBiz(new String[]{getBizUnit(beanObject, frameBiz)});
                executeRegister.register(executeInfo);
            });
        });
    }

    private String getChannel(Object beanObject, FrameBiz frameBiz) {

        // 注解为空
        if (Objects.isNull(frameBiz)) {
            ChannelInfo info = (ChannelInfo) beanObject;
            return info.code();
        }
        String channel = frameBiz.channel();
        return StringUtils.isBlank(channel) ? DefaultBiz.defaultBiz : channel;
    }

    private String getBizUnit(Object beanObject, FrameBiz frameBiz) {

        // 注解为空
        if (Objects.nonNull(frameBiz)) {

            Assert.notEmpty(frameBiz.bizUnit(), "please config @FrameBiz bizUnit");
            return frameBiz.bizUnit()[0];
        }

        if (beanObject instanceof BizUnit) {
            return ((BizUnit) beanObject).unit();
        }

        throw new ChannelException("please impl BizUnit interface or use @FrameBiz");
    }

    public void destroy() {

        executeRegister.clear();

    }


}

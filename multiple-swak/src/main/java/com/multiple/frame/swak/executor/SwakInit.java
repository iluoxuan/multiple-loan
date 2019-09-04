package com.multiple.frame.swak.executor;

import com.multiple.frame.swak.annotation.SwakBiz;
import com.multiple.frame.swak.annotation.SwakInterface;
import com.multiple.frame.swak.entity.ExecuteInfo;
import com.multiple.frame.swak.register.SwakRegister;
import lombok.Data;
import org.assertj.core.util.Lists;
import org.springframework.context.ApplicationContext;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.CollectionUtils;

import java.util.Map;

/**
 * 初始化
 *
 * @author: junqing.li
 * @date: 2019/9/4
 */
@Data
public class SwakInit {

    private SwakRegister swakRegister;

    private ApplicationContext applicationContext;

    /**
     * 初始化
     */
    public void init() {

        // 找到
        Map<String, Object> swakBizs = applicationContext.getBeansWithAnnotation(SwakInterface.class);
        if (CollectionUtils.isEmpty(swakBizs)) {
            return;
        }

        swakBizs.entrySet().forEach(entry -> {

            Object bean = entry.getValue();
            SwakBiz swakBiz = AnnotationUtils.findAnnotation(bean.getClass(), SwakBiz.class);

            ExecuteInfo executeInfo = new ExecuteInfo();
            executeInfo.setTags(Lists.newArrayList(swakBiz.tags()));
            executeInfo.setTarget(bean);
            executeInfo.setBizCode(swakBiz.bizCode());
            swakRegister.register(executeInfo);

        });

    }

    public void destroy(){
        swakRegister.clear();
    }
}

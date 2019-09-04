package com.multiple.frame.core.endpoint;

import com.google.common.collect.Maps;
import com.multiple.frame.common.support.FrameInterceptor;
import com.multiple.frame.common.support.GlobalInterceptor;
import com.multiple.frame.common.support.Interceptor;
import com.multiple.frame.core.register.ExecuteRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;

import java.util.List;
import java.util.Map;

/**
 * @author: junqing.li
 * @date: 2019/9/3
 */
@Endpoint(id = "multiple-frame")
public class FrameEndpoint {

    @Autowired
    private ExecuteRegister executeRegister;

    @Autowired
    private List<Interceptor> interceptorList;

    @ReadOperation
    public Map<String, Map<String, Object>> executes() {

        Map<String, Map<String, Object>> result = Maps.newHashMap();
        Map<String, Object> executes = Maps.newHashMap();

        executeRegister.all().entrySet().forEach(entry -> {

            executes.put(entry.getKey(), entry.getValue().toString());
        });

        result.put("executes", executes);

        Map<String, Object> interceptors = Maps.newHashMap();

        interceptorList.stream().forEach(interceptor -> {

            String key = "";

            if (interceptor instanceof GlobalInterceptor) {
                key = "global-" + interceptor.getClass().getSimpleName();
            } else {

                key = ((FrameInterceptor) interceptor).nameKey().name();
            }

            Integer order = OrderUtils.findOrder(interceptor);

            interceptors.put(key, interceptorFormat(interceptor, order));
        });

        result.put("interceptors", interceptors);

        return result;

    }

    private String interceptorFormat(Interceptor interceptor, Integer order) {
        String format = "{\"order\":\"%s\", \"bean\":\"%s\"}";
        return String.format(format, order, interceptor.toString());
    }


}

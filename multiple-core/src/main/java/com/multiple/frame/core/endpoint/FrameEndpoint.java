package com.multiple.frame.core.endpoint;

import com.google.common.collect.Maps;
import com.multiple.frame.core.register.ExecuteRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;

import java.util.Map;

/**
 * @author: junqing.li
 * @date: 2019/9/3
 */
@Endpoint(id = "multiple-frame")
public class FrameEndpoint {

    @Autowired
    private ExecuteRegister executeRegister;

    @ReadOperation
    public Map<String, String> executes() {

        Map<String, String> result = Maps.newHashMap();

        executeRegister.all().entrySet().forEach(entry -> {

            result.put(entry.getKey(), entry.getValue().toString());
        });
        return result;
    }
}

package com.multiple.frame.core.endpoint;

import com.multiple.frame.common.base.ExecuteInfo;
import com.multiple.frame.core.register.ExecuteRegister;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;

import java.util.List;

/**
 * @author: junqing.li
 * @date: 2019/9/3
 */
@WebEndpoint(id = "frame")
public class FrameEndpoint {

    @Autowired
    private ExecuteRegister executeRegister;

    @ReadOperation
    public List<ExecuteInfo> executes() {
        return executeRegister.all();
    }
}

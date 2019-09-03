package com.multiple.frame.gw.service;

import com.multiple.frame.common.base.ChannelParam;
import com.multiple.frame.core.dispatch.BizDispatch;
import com.multiple.frame.gw.entity.RpcRequest;
import com.multiple.frame.gw.entity.RpcResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: junqing.li
 * @date: 2019/8/31
 */
@Component
public class RpcServiceTest {

    @Autowired
    private BizDispatch bizDispatch;


    public RpcResponse<?> dispatch(RpcRequest request){


        ChannelParam param = new ChannelParam();
        param.setChannelCode(request.getChannelCode());
        param.setBizMethod(request.getMethod());
        param.setRequestBody(request.getParam());

       return (RpcResponse)bizDispatch.doDispatch(param);

    }
}

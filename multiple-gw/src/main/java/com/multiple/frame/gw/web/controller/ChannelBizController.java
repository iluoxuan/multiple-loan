package com.multiple.frame.gw.web.controller;

import com.multiple.frame.common.base.ChannelParam;
import com.multiple.frame.core.dispatch.BizDispatch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author: junqing.li
 * @date: 2019/8/28
 */
@RestController
public class ChannelBizController {

    @Autowired
    private BizDispatch bizDispatch;

    @PostMapping("/biz/{channel}/{method}")
    public Object dispatch(@PathVariable(name = "channel") String channel,
                           @PathVariable(name = "method") String method,
                           @RequestBody String requestBody) {

        ChannelParam param = new ChannelParam();
        param.setChannelCode(channel);
        param.setBizMethod(method);
        param.setRequestBody(requestBody);
        return bizDispatch.doDispatch(param);
    }

}

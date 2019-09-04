package com.multiple.frame.gw.web.controller;

import com.multiple.frame.common.base.ChannelParam;
import com.multiple.frame.core.dispatch.BizDispatch;
import com.multiple.frame.gw.biz.swak.SwakService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @author: junqing.li
 * @date: 2019/8/28
 */
@RestController
public class ChannelBizController {

    @Autowired
    private BizDispatch bizDispatch;

    @Autowired
    private SwakService swakService;

    @PostMapping("/biz/{channel}/{method}")
    public Object dispatch(@PathVariable(name = "channel") String channel, @PathVariable(name = "method") String method,
                           @RequestBody String requestBody) {

        ChannelParam param = new ChannelParam();
        param.setChannelCode(channel);
        param.setBizMethod(method);
        param.setRequestBody(requestBody);
        return bizDispatch.doDispatch(param);
    }

    /**
     * 内部 method 参数调用方法
     *
     * @param channel
     * @param requestBody
     * @return
     */
    @PostMapping("/biz/{channel}")
    public Object dispatchMethod(@PathVariable(name = "channel") String channel, @RequestBody String requestBody) {

        ChannelParam param = new ChannelParam();
        param.setChannelCode(channel);
        param.setRequestBody(requestBody);
        return bizDispatch.doDispatch(param);
    }

    @GetMapping("/test")
    public String test(){
        return swakService.test();
    }

}

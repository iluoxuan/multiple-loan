package com.multiple.frame.gw.biz.swak.test;

import com.multiple.frame.swak.annotation.SwakBiz;
import com.multiple.frame.swak.entity.SwakContext;

/**
 * @author: junqing.li
 * @date: 2019/9/4
 */
@SwakBiz(tags = "manwei")
public class ManWeiPayBiz implements PayBiz {

    @Override
    public String getPayUrl(String channel, SwakContext context) {

        return "manwei---- getpayUrl";
    }
}

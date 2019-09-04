package com.multiple.frame.gw.biz.swak.test;

import com.multiple.frame.swak.annotation.SwakBiz;
import com.multiple.frame.swak.entity.SwakContext;
import org.springframework.context.annotation.Primary;

/**
 * @author: junqing.li
 * @date: 2019/9/4
 */
@Primary
@SwakBiz
public class DefaultPayBiz implements PayBiz {

    @Override
    public String getPayUrl(String channel, SwakContext context) {
        return "default --- biz";
    }
}

package com.multiple.frame.gw.biz.swak.test;

import com.multiple.frame.swak.annotation.SwakInterface;
import com.multiple.frame.swak.entity.SwakContext;

/**
 * @author: junqing.li
 * @date: 2019/9/4
 */
@SwakInterface(desc = "支持业务")
public interface PayBiz {


    String getPayUrl(String channel, SwakContext context);
}

package com.multiple.frame.gw.biz.swak;

import com.multiple.frame.swak.annotation.SwakInterface;
import com.multiple.frame.swak.annotation.SwakMethod;

/**
 * @author: junqing.li
 * @date: 2019/9/4
 */
@SwakInterface(desc = "发财")
public interface BigMoney {

    @SwakMethod
    String getMoreMoney(String name, String big);
}

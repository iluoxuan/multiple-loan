package com.multiple.frame.gw.biz.swak;

import com.multiple.frame.swak.annotation.SwakBiz;

/**
 * @author: junqing.li
 * @date: 2019/9/4
 */
@SwakBiz
public class BigMoneyDefault implements BigMoney {

    @Override
    public String getMoreMoney(String name, String big) {
        return " BigMoneyDefault xxxx default";
    }
}

package com.multiple.frame.gw.biz.swak;

import com.multiple.frame.swak.annotation.SwakBiz;
import lombok.extern.slf4j.Slf4j;

/**
 * @author: junqing.li
 * @date: 2019/9/4
 */
@Slf4j
@SwakBiz(tags = "bigMoney2")
public class BigMoneyTest2 implements BigMoney {

    @Override
    public String getMoreMoney(String name, String big) {

        log.info("[xxxx] --BigMoneyTest2");

        return "xxxxxx bigMoney2" + name;
    }
}

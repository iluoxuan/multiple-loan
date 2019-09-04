package com.multiple.frame.gw.biz.swak;

import com.multiple.frame.swak.annotation.SwakBiz;
import com.multiple.frame.swak.annotation.SwakMethod;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

/**
 * @author: junqing.li
 * @date: 2019/9/4
 */
@Slf4j
@Primary
@SwakBiz(tags = "test1")
public class BigMoneyTest1 implements BigMoney {

    @Autowired
    private BigBigService bigBigService;

    @Override
    public String getMoreMoney(String name, String big) {

        log.info("[xxxx] === BigMoneyTest1");

        bigBigService.bigTest();

        return "xxxxxx" + name;
    }
}

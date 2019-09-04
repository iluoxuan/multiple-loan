package com.multiple.frame.gw.biz.swak;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author: junqing.li
 * @date: 2019/9/4
 */
@Component
public class SwakService {

    @Autowired
    private BigMoney bigMoney;


    public String test() {
        return bigMoney.getMoreMoney("xxxx", "heee");
    }
}

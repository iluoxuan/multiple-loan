package com.multiple.frame.gw.biz.swak;

import com.multiple.frame.swak.entity.SwakContext;
import com.multiple.frame.swak.entity.SwakLocal;
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

        SwakContext swakContext = new SwakContext("bigMoney2");
        SwakLocal.getCurrent().setContext(swakContext);
        return bigMoney.getMoreMoney("xxxx", "heee");
    }
}

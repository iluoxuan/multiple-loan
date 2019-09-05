package com.multiple.frame.gw.biz.swak;

import com.multiple.frame.swak.entity.SwakContext;
import com.multiple.frame.swak.entity.SwakLocal;
import org.assertj.core.util.Lists;
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
        SwakLocal.getCurrent().setContext(new SwakContext(Lists.newArrayList("bigMoney2"), ""));
        return bigMoney.getMoreMoney("xxxx", "heee");
    }
}

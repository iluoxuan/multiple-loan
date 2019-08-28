package com.multiple.frame.gw.biz.unit.defaultunit;

import com.multiple.frame.gw.biz.unit.PayBizUnit;
import org.springframework.stereotype.Component;

/**
 * @author: junqing.li
 * @date: 2019/8/28
 */
@Component
public class DefaultPayBizUnit implements PayBizUnit {

    @Override
    public String getRepaymentUrl() {
        return "xxxxxxxx -url ";
    }

    @Override
    public String unit() {

        return defaultUnit;
    }
}

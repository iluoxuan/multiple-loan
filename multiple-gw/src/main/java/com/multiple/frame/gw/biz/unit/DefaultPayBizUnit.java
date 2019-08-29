package com.multiple.frame.gw.biz.unit;

import com.multiple.frame.common.base.BizUnit;
import com.multiple.frame.gw.biz.PayBiz;
import org.springframework.stereotype.Component;

/**
 * @author: junqing.li
 * @date: 2019/8/28
 */
@Component
public class DefaultPayBizUnit implements PayBiz, BizUnit {

    @Override
    public String getRepaymentUrl() {
        return "xxxxxxxx -url ";
    }

    @Override
    public String unit() {

        return defaultUnit;
    }
}

package com.multiple.frame.gw.biz.unit;

import com.multiple.frame.common.base.BizUnit;
import com.multiple.frame.gw.biz.ApplyBiz;
import org.springframework.stereotype.Component;

/**
 * @author: junqing.li
 * @date: 2019/8/29
 */
@Component
public class SecondApplyBizUnit implements ApplyBiz, BizUnit {

    @Override
    public String userCheck() {
        return "------[SecondApplyBizUnit] --- in test";
    }

    @Override
    public String unit() {
        return "second";
    }
}

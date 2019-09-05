package com.multiple.frame.gw.biz.unit;

import com.multiple.frame.common.base.FrameBiz;
import com.multiple.frame.gw.biz.ApplyBiz;
import com.multiple.frame.swak.annotation.SwakBiz;
import org.springframework.stereotype.Component;

/**
 * @author: junqing.li
 * @date: 2019/8/29
 */
@SwakBiz(tags = "second")
@FrameBiz(bizUnit = {"second"})
@Component
public class SecondApplyBizUnit implements ApplyBiz {

    @Override
    public String userCheck() {
        return "------[SecondApplyBizUnit] --- in test";
    }
}

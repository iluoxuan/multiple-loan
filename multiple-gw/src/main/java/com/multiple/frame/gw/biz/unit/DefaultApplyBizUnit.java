package com.multiple.frame.gw.biz.unit;


import com.multiple.frame.common.base.BizUnit;
import com.multiple.frame.common.base.FrameBiz;
import com.multiple.frame.gw.biz.ApplyBiz;
import org.springframework.stereotype.Component;

/**
 * @author: junqing.li
 * @date: 2019/8/27
 */
@FrameBiz(bizUnit = {BizUnit.defaultUnit})
@Component
public class DefaultApplyBizUnit implements ApplyBiz {

    @Override
    public String userCheck() {

        // UserCheckReq req = LocalContext.getCurrentContext().getTargetObject();

        return "user check in default appy bizUnit";
    }
}

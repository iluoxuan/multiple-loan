package com.multiple.frame.gw.biz.unit;


import com.multiple.frame.common.base.BizUnit;
import com.multiple.frame.gw.biz.ApplyBiz;
import org.springframework.stereotype.Component;

/**
 * @author: junqing.li
 * @date: 2019/8/27
 */
@Component
public class DefaultApplyBizUnit implements ApplyBiz, BizUnit {

    @Override
    public String userCheck() {

        return "user check in default appy bizUnit";
    }
}

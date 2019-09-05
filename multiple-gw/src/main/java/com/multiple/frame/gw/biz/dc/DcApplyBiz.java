package com.multiple.frame.gw.biz.dc;

import com.multiple.frame.common.base.FrameBiz;
import com.multiple.frame.gw.biz.ApplyBiz;
import com.multiple.frame.swak.annotation.SwakBiz;
import org.springframework.stereotype.Component;

/**
 * @author: junqing.li
 * @date: 2019/9/4
 */
@SwakBiz(bizCode = "dc")
@FrameBiz(channel = "dc")
@Component
public class DcApplyBiz implements ApplyBiz {

    @Override
    public String userCheck() {
        return "test in dc";
    }
}

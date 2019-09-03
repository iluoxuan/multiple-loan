package com.multiple.frame.gw.biz.dc;

import com.multiple.frame.common.base.FrameBiz;
import com.multiple.frame.gw.biz.ApplyBiz;
import org.springframework.stereotype.Component;

/**
 * @author: junqing.li
 * @date: 2019/9/4
 */
@FrameBiz(channel = "dc")
@Component
public class DcApplyBiz implements ApplyBiz {

    @Override
    public String userCheck() {
        return "test in dc";
    }
}

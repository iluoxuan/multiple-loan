package com.multiple.frame.gw.biz.swak.test;

import com.multiple.frame.gw.biz.swak.BigBigService;
import com.multiple.frame.gw.biz.swak.SwakService;
import com.multiple.frame.swak.annotation.SwakBiz;
import com.multiple.frame.swak.entity.SwakContext;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author: junqing.li
 * @date: 2019/9/4
 */
@SwakBiz(tags = "dc")
public class DcPayBiz implements PayBiz {

    @Autowired
    private BigBigService bigBigService;

    @Autowired
    private SwakService swakService;

    @Override
    public String getPayUrl(String channel, SwakContext context) {


        bigBigService.bigTest();

        swakService.test();

        return "dc --- get pay Url";
    }
}

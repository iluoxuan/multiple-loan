package com.multiple.frame.gw.biz.swak.test;

import com.multiple.frame.gw.biz.swak.SwakService;
import com.multiple.frame.swak.entity.SwakContext;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author: junqing.li
 * @date: 2019/9/4
 */
@Service
public class HejService {

    @Autowired
    private PayBiz payBiz;

    @Autowired
    private SwakService swakService;

    public void getBigPlan(String param) {

        SwakContext context = new SwakContext();
        context.setTags(Lists.newArrayList("dc"));
        String result = payBiz.getPayUrl("dc", context);
        System.out.println("===");
        System.out.println(result);


        swakService.test();


    }
}

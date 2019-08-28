package com.multiple.frame.core.dispatch;

import com.multiple.frame.common.base.ChannelParam;

/**
 * @author: junqing.li
 * @date: 2019/8/28
 */
public interface BizDispatch {

    /**
     * 入口
     * @param param
     * @return
     */
    Object doDispatch(ChannelParam param);
}

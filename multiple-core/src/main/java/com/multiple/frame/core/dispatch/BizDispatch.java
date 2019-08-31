package com.multiple.frame.core.dispatch;

import com.multiple.frame.common.base.ChannelParam;

/**
 * 怎么同时
 * 兼容 http/rpc 调用
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

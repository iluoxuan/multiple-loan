package com.multiple.frame.common.base;

/**
 * @author: junqing.li
 * @date: 2019/8/27
 */
public interface DefaultBiz extends ChannelInfo {

    String defaultBiz = "default";

    @Override
    default String code() {
        return defaultBiz;
    }
}

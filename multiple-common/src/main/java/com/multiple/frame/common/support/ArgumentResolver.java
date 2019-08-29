package com.multiple.frame.common.support;

import com.multiple.frame.common.base.ChannelExchange;

/**
 * 参数 解析
 * <p>
 * 1. 解析公用部分 [-- 三方实现]
 * 2. 解析到对应的 模板对象 [-- 三方实现]
 * 3. other
 *
 * @author: junqing.li
 * @date: 2019/8/29
 */
public interface ArgumentResolver {


    /**
     * 支持参数
     *
     * @return exchange
     */
    boolean supports(ChannelExchange exchange);

    /**
     * 处理
     *
     * @param exchange
     */
    void resolveArgument(ChannelExchange exchange);


}

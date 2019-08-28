package com.multiple.frame.gw.biz;

import com.multiple.frame.common.base.ChannelInfo;

/**
 * 支持接口
 *
 * @author: junqing.li
 * @date: 2019/7/10
 */
public interface PayBiz extends ChannelInfo {

    /**
     * 懒人还款url / 对应渠道的主动还款url
     */
    default <R> R getRepaymentUrl() {
        throw new UnsupportedOperationException();
    }

    /**
     * 还款计划详情查询-当前期数的
     *
     * @param <R> 返回
     */
    default <R> R getRepaymentDetail() {
        throw new UnsupportedOperationException();
    }


    /**
     * 获取还款计划
     *
     * @return 返回
     */
    default <R> R getRepaymentPlan() {
        throw new UnsupportedOperationException();
    }


}
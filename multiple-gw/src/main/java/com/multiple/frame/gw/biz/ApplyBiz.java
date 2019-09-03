package com.multiple.frame.gw.biz;

import com.multiple.frame.common.base.ChannelInfo;

/**
 * 申请 业务
 *
 * @author: junqing.li
 * @date: 2019/8/27
 */
public interface ApplyBiz{

    /**
     * 申请资格校验
     *
     * @param
     * @param <R> 返回实体
     */
    default <R> R userCheck() {
        throw new UnsupportedOperationException();
    }

    /**
     * 订单申请
     *
     * @param
     * @return 返回实体
     */
    default <R> R orderApply() {
        throw new UnsupportedOperationException();
    }

    /**
     * 获取授信结果
     */
    default <R> R getApproveResult() {
        throw new UnsupportedOperationException();
    }

    /**
     * 获取订单状态
     */
    default <R> R getOrderStatus() {
        throw new UnsupportedOperationException();
    }

    /**
     * 保存基本信息
     *
     * @param
     * @param <R>
     * @return
     */
    default <R> R saveBasicInfo() {
        throw new UnsupportedOperationException();
    }

    /**
     * 保存补充信息
     *
     * @param
     * @param <R>
     * @return
     */
    default <R> R saveAddInfo() {
        throw new UnsupportedOperationException();
    }
}

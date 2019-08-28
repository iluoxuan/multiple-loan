package com.multiple.frame.gw.biz;

import com.multiple.frame.common.base.ChannelInfo;

/**
 * 银行卡业务
 *
 * @author: junqing.li
 * @date: 2019/7/10
 */
public interface BankCardBiz extends ChannelInfo {


    /**
     * 获取可用银行列表
     */
    default <R> R getBankList() {
        throw new UnsupportedOperationException();
    }


    /**
     * 获取 签约银行卡
     *
     * @param <R> 返回实体
     * @return 返回
     */
    default <R> R getSignBankList() {
        throw new UnsupportedOperationException();
    }


    /**
     * 绑卡接口
     */
    default <R> R bindCard() {
        throw new UnsupportedOperationException();
    }


    /**
     * 拉取绑卡结果
     */
    default <R> R getBindResult() {
        throw new UnsupportedOperationException();
    }


    default <R> R checkVerifyCode() {
        throw new UnsupportedOperationException();
    }

}

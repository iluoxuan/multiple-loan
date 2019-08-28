package com.multiple.frame.common.exception;

/**
 * 异常码
 *
 * @author: junqing.li
 * @date: 2019/8/27
 */
public interface ErrorCode {

    /**
     * 成功
     *
     * @return
     */
    default String ok() {
        return DefaultErrorCode.ok.name();
    }

    /**
     * 签名类型错误
     *
     * @return
     */
    default String sign() {
        return DefaultErrorCode.sign.name();
    }

    /**
     * 服务错误
     *
     * @return
     */
    default String error() {
        return DefaultErrorCode.error.name();
    }

    /**
     * 参数类型错误
     *
     * @return
     */
    default String param() {
        return DefaultErrorCode.param.name();
    }
}

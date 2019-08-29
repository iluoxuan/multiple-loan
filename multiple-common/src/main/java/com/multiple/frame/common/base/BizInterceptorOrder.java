package com.multiple.frame.common.base;

/**
 * @author: junqing.li
 * @date: 2019/8/28
 */
public interface BizInterceptorOrder {

    /**
     * 请求解析
     */
    int requestParser = -1100;

    /**
     * 寻找执行器
     */
    int lookExecute = -1000;

    /**
     * 参数解析
     */
    int argumentResolve = -900;

    /**
     * 执行方法
     */
    int invokerMethod = 100;

    /**
     * 返回值处理
     */
    int returnValueHandler = 200;


}

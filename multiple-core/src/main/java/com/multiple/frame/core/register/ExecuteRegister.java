package com.multiple.frame.core.register;

import com.multiple.frame.common.base.ExecuteInfo;

import java.util.List;
import java.util.Map;

/**
 * 执行器注册
 *
 * @author: junqing.li
 * @date: 2019/9/3
 */
public interface ExecuteRegister {

    /**
     * 注册执行信息
     *
     * @param executeInfo
     */
    void register(ExecuteInfo executeInfo);

    /**
     * lookUp
     *
     * @param channel
     * @param unitBiz
     * @param method
     * @return
     */
    ExecuteInfo lookUp(String channel, String method, List<String> unitBiz);

    /**
     * 所有的
     *
     * @return
     */
    Map<String, ExecuteInfo> all();

    /**
     * 清理
     */
    void clear();


}

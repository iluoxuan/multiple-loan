package com.multiple.frame.swak.register;

import com.multiple.frame.swak.entity.InterfaceExecuteInfo;
import com.multiple.frame.swak.entity.MethodExecuteInfo;
import com.multiple.frame.swak.entity.SwakContext;

/**
 * @author: junqing.li
 * @date: 2019/9/4
 */
public interface SwakRegister {

    /**
     * 注册 执行信息
     *
     * @param executeInfo
     */
    void register(InterfaceExecuteInfo executeInfo);

    /**
     * 调用
     *
     * @param executeInfo
     */
    void register(MethodExecuteInfo executeInfo);


    InterfaceExecuteInfo lookUp(InterfaceExecuteInfo executeInfo);

    MethodExecuteInfo lookMethod(SwakContext swakContext);

    /**
     * clear
     */
    void clear();

}

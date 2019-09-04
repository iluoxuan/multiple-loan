package com.multiple.frame.swak.register;

import com.multiple.frame.swak.entity.ExecuteInfo;

import java.util.List;

/**
 * @author: junqing.li
 * @date: 2019/9/4
 */
public interface SwakRegister {

    /**
     * 注册 执行信息
     * @param executeInfo
     */
    void register(ExecuteInfo executeInfo);

    /**
     * 寻找 执行
     * @param tags
     * @return
     */
    ExecuteInfo lookUp(List<String> tags);

    /**
     * clear
     */
    void clear();

}

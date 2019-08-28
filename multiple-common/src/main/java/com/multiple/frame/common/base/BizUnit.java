package com.multiple.frame.common.base;

/**
 * @author: junqing.li
 * @date: 2019/8/27
 */
public interface BizUnit extends DefaultBiz {

    String defaultUnit = "default";

    /**
     * 业务单元 名称
     *
     * @return
     */
    default String unit() {
        return defaultUnit;
    }
}

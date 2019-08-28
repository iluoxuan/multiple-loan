package com.multiple.frame.parser.resouce;

import org.springframework.core.io.Resource;

/**
 * 模板资源
 * <p>
 * 设计模型 {@link Resource}
 *
 * @author: junqing.li
 * @date: 2019/8/28
 */
public interface ResourceLoader {

    /**
     * 资源类型
     * @return
     */
    String type();

    /**
     * 读取内容
     * @param resoucePath
     *  [template/{channel}/req/{method}]
     * @return
     */
    TemplateResource read(String resoucePath) throws Exception;
}

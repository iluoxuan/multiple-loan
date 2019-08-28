package com.multiple.frame.parser.parser;

/**
 * 模板解析
 *
 * @author: junqing.li
 * @date: 2019/8/28
 */
public interface TemplateParser<T> {

    /**
     * 分隔符
     **/
    String delimiter = ":";

    /**
     * 解析模板
     *
     * @param data
     * @return
     */
    T parser(String data);

}

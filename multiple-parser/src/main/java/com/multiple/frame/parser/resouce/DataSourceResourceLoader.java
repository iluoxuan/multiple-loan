package com.multiple.frame.parser.resouce;

/**
 * 数据源中读取
 * @author: junqing.li
 * @date: 2019/8/28
 */
public abstract class DataSourceResourceLoader implements ResourceLoader {


    @Override
    public String type() {
        return ResourceType.dataSource;
    }

}

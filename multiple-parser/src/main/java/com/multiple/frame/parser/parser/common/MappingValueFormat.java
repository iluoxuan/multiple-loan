package com.multiple.frame.parser.parser.common;

import com.alibaba.fastjson.JSON;
import com.multiple.frame.parser.parser.TemplateParser;
import lombok.Data;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;

/**
 * 映射的 值 格式
 * channelKey:valueType:defaultValue:unit
 *
 * @author: junqing.li
 * @date: 2019/8/28
 */
@Data
public class MappingValueFormat {

    /**
     * 渠道的参数名称
     */
    private String channelKey;

    /**
     * 值类型
     */
    private String valueType;

    /**
     * 默认值
     */
    private String defaultValue;

    /**
     * 单位
     */
    private String unit;

    public void format(String mappingValue) {
        String[] values = StringUtils.split(mappingValue, TemplateParser.delimiter);
        Assert.isTrue(values.length >= 2, "please check config must hash key and value type");

        channelKey = values[0];
        valueType = values[1];

        if (values.length >= 3) {
            defaultValue = values[2];
        }
        if (values.length >= 4) {
            unit = values[3];
        }

    }

    /**
     * 获取默认值
     *
     * @return
     */
    public Object getDefaultValue() {
        return MappingValueFormat.getValue(defaultValue, valueType);
    }

    /**
     * 获取值
     *
     * @param valueStr
     * @param valueType
     * @return
     */
    public static Object getValue(String valueStr, String valueType) {

        if (ValueType.isDouble(valueType)) {
            return Double.valueOf(valueStr);
        }
        if (ValueType.isInt(valueType)) {
            return Integer.valueOf(valueStr);
        }
        if (ValueType.isLong(valueType)) {
            return Long.valueOf(valueStr);
        }
        if (ValueType.isObject(valueType)) {
            return JSON.parseObject(valueStr);
        }
        return valueStr;
    }
}

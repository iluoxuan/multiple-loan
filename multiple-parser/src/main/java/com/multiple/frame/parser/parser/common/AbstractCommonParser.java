package com.multiple.frame.parser.parser.common;

import com.alibaba.fastjson.JSON;
import com.google.common.collect.Maps;
import com.google.common.reflect.TypeToken;
import com.multiple.frame.common.exception.ChannelException;
import com.multiple.frame.parser.parser.TemplateParser;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.commons.lang3.reflect.FieldUtils;
import org.springframework.util.Assert;

import java.lang.reflect.ParameterizedType;
import java.util.Map;

/**
 * @author: junqing.li
 * @date: 2019/8/28
 */
@Slf4j
public abstract class AbstractCommonParser<T extends CommonTemplate> implements TemplateParser<CommonTemplate> {

    @Override
    public T parser(String data) {

        T template = JSON.parseObject(data, getT());

        Map<String, String> mappingMap = template.getMapping();
        Assert.notEmpty(mappingMap, "please config request common template");

        Map<String, MappingValueFormat> valueFormatMap = Maps.newHashMap();

        mappingMap.entrySet().stream().forEach(entry -> {

            String templateKey = entry.getKey();
            String channelValue = entry.getValue();

            // 解析 channelValue
            MappingValueFormat valueFormat = new MappingValueFormat();
            valueFormat.format(channelValue);
            valueFormatMap.put(templateKey, valueFormat);

            // 反射执行设置值
            try {
                FieldUtils.writeDeclaredField(template, templateKey, valueFormat.getChannelKey(), true);
            } catch (IllegalAccessException e) {
                log.error("[parser] templateKey={} error={}", templateKey, ExceptionUtils.getStackTrace(e));
                throw new ChannelException("request parser error");
            }
        });

        return template;
    }

    /**
     * 获取 类上泛型
     *
     * @return
     */
    protected Class<T> getT() {
        TypeToken tt = TypeToken.of(this.getClass());
        TypeToken st = tt.getSupertype(AbstractCommonParser.class);
        return (Class<T>) ((ParameterizedType) st.getType()).getActualTypeArguments()[0];
    }
}

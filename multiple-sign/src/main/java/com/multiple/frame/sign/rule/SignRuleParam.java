package com.multiple.frame.sign.rule;

import com.google.common.collect.Sets;
import lombok.Data;
import org.springframework.util.StringUtils;

import java.util.Map;
import java.util.Set;

/**
 * @author: junqing.li
 * @date: 2019/7/11
 */
@Data
public class SignRuleParam {

    /**
     * 所有参数集合
     */
    private Map<String, Object> dataMap;


    /**
     * 内部业务参数 body jsonstring
     */
    private String dataContent;

    /**
     * 渠道方appId
     */
    private String appId;


    /**
     * 排除的字段
     *
     * @return
     */
    private String exclude;

    public Set<String> getExcludes() {
        if (!StringUtils.hasText(exclude)) {
            return Sets.newHashSet();
        }
        return StringUtils.commaDelimitedListToSet(exclude);
    }


}

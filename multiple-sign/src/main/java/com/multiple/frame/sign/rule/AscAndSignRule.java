package com.multiple.frame.sign.rule;

import lombok.extern.slf4j.Slf4j;

import java.util.Comparator;
import java.util.Map;
import java.util.Map.Entry;

/**
 * 自然排序然后& 规则
 *
 * @author: junqing.li
 * @date: 2019/7/11
 */
@Slf4j
public class AscAndSignRule implements SignRule {

    @Override
    public SignRuleName name() {
        return SignRuleType.AscAnd;
    }

    @Override
    public String rule(SignRuleParam param) {

        Map<String, Object> dataMap = param.getDataMap();

        String signData = dataMap.entrySet().stream().sorted(Comparator.comparing(Entry::getKey))
                .filter(entry -> !param.getExcludes().contains(entry.getKey()))
                .map(a -> a.getKey() + "=" + a.getValue())
                .reduce((a, b) -> a + "&" + b).orElse(null);

        log.info("[rule] signData=[ {} ]", signData);

        return signData;

    }


}

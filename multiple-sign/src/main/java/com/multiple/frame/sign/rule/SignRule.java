package com.multiple.frame.sign.rule;

/**
 * 签名规则
 * @author: junqing.li
 * @date: 2019/8/27
 */
public interface SignRule {

    /**
     * 规则名称
     * @return
     */
    SignRuleName name();

    /**
     * 生产 规则字符串
     * @param param
     * @return
     */
    String rule(SignRuleParam param);
}

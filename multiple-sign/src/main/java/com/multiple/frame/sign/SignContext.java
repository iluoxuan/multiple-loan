package com.multiple.frame.sign;

import com.multiple.frame.sign.rule.SignRuleParam;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author: junqing.li
 * @date: 2019/8/27
 */
@Data
public class SignContext {

    @NotNull
    private SignConfig signConfig;

    @NotNull
    private SignRuleParam signRuleParam;

    /**
     * 签名
     */
    private String sign;

}

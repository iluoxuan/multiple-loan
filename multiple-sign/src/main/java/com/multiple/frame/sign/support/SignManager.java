package com.multiple.frame.sign.support;

import com.multiple.frame.common.exception.ChannelSingException;
import com.multiple.frame.sign.encrypt.SignEncrypt;
import com.multiple.frame.sign.encrypt.SignEncryptParam;
import com.multiple.frame.sign.rule.SignRule;
import lombok.*;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.List;
import java.util.Optional;

/**
 * @author: junqing.li
 * @date: 2019/8/27
 */
@Slf4j
@Getter
@Setter
public class SignManager {

    private List<SignRule> signRules;

    private List<SignEncrypt> signEncrypts;

    public boolean verifySign(SignContext signContext) {

        checkVerifySign(signContext);

        try {

            Holder holder = getHandler(signContext);
            return holder.getSignEncrypt().verifySign(holder.getSignEncryptParam());
        } catch (Exception e) {
            log.error("[verifySign] verify sign error={}", ExceptionUtils.getStackTrace(e));
            throw new ChannelSingException("sign verify error");
        }
    }

    public String createSign(SignContext signContext) {

        checkCreateSign(signContext);

        try {

            Holder holder = getHandler(signContext);
            return holder.getSignEncrypt().createSign(holder.getSignEncryptParam());
        } catch (Exception e) {
            log.error("[verifySign] verify sign error={}", ExceptionUtils.getStackTrace(e));
            throw new ChannelSingException("sign verify error");
        }
    }


    /**
     * 验证签名
     *
     * @param signContext
     * @return
     */
    public Holder getHandler(SignContext signContext) {

        SignConfig signConfig = signContext.getSignConfig();

        Optional<SignRule> ruleOptional = signRules.stream()
                .filter(signRule -> signRule.name().equals(signConfig.getRule())).findFirst();

        if (!ruleOptional.isPresent()) {
            throw new ChannelSingException("no find sign rule");
        }

        SignRule signRule = ruleOptional.get();

        Optional<SignEncrypt> encryptOptional = signEncrypts.stream()
                .filter(signEncrypt -> signEncrypt.name().equals(signConfig.getEncrypt()))
                .findFirst();

        if (!encryptOptional.isPresent()) {
            throw new ChannelSingException("no find sign encrypt");
        }


        SignEncryptParam signEncryptParam = new SignEncryptParam();
        signEncryptParam.setRuleData(signRule.rule(signContext.getSignRuleParam()));
        signEncryptParam.setSign(signContext.getSign());
        SignEncrypt signEncrypt = encryptOptional.get();

        return Holder.builder().signEncrypt(signEncrypt).signEncryptParam(signEncryptParam).build();
    }

    @AllArgsConstructor
    @NoArgsConstructor
    @Builder
    @Data
    public static class Holder {

        private SignEncrypt signEncrypt;

        private SignEncryptParam signEncryptParam;

    }


    private void checkVerifySign(SignContext signContext) {

        if (CollectionUtils.isEmpty(signRules) || CollectionUtils.isEmpty(signEncrypts)) {
            throw new ChannelSingException("no rule or encrypt impl config");
        }

        // 验证配置
        signContext.getSignConfig().checkSignConfig();

        if (!StringUtils.hasText(signContext.getSignConfig().getChannelPublicKey())) {
            throw new ChannelSingException("no channel public key config");
        }
    }

    private void checkCreateSign(SignContext signContext) {

        if (CollectionUtils.isEmpty(signRules) || CollectionUtils.isEmpty(signEncrypts)) {
            throw new ChannelSingException("no rule or encrypt impl config");
        }

        // 验证配置
        signContext.getSignConfig().checkSignConfig();

        if (!StringUtils.hasText(signContext.getSignConfig().getPrivateKey())) {
            throw new ChannelSingException("no privateKey public key config");
        }
    }

}

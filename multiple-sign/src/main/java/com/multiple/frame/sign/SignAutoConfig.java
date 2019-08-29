package com.multiple.frame.sign;

import com.multiple.frame.sign.config.SignProperties;
import com.multiple.frame.sign.encrypt.SignEncrypt;
import com.multiple.frame.sign.rule.SignRule;
import com.multiple.frame.sign.support.SignManager;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;

/**
 * @author: junqing.li
 * @date: 2019/8/27
 */
@EnableConfigurationProperties(SignProperties.class)
@Configuration
public class SignAutoConfig {

    @Bean
    public SignManager signManager(List<SignRule> signRules, List<SignEncrypt> signEncrypts) {
        SignManager signManager = new SignManager();
        signManager.setSignEncrypts(signEncrypts);
        signManager.setSignRules(signRules);
        return signManager;
    }

}

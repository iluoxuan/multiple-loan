package com.multiple.frame.sign;

import com.multiple.frame.sign.config.SignProperties;
import com.multiple.frame.sign.encrypt.MD5withRSASignEncrypt;
import com.multiple.frame.sign.encrypt.SHA1withRSASignEncrypt;
import com.multiple.frame.sign.encrypt.SignEncrypt;
import com.multiple.frame.sign.rule.AscAndSignRule;
import com.multiple.frame.sign.rule.SignRule;
import com.multiple.frame.sign.support.SignManager;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
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
    @ConditionalOnMissingBean(name = "sha1withRSASignEncrypt")
    public SHA1withRSASignEncrypt sha1withRSASignEncrypt() {
        return new SHA1withRSASignEncrypt();
    }

    @Bean
    @ConditionalOnMissingBean(name = "md5withRSASignEncrypt")
    public MD5withRSASignEncrypt md5withRSASignEncrypt() {
        return new MD5withRSASignEncrypt();
    }

    @Bean
    @ConditionalOnMissingBean(name = "ascAndSignRule")
    public AscAndSignRule ascAndSignRule() {

        AscAndSignRule signRule = new AscAndSignRule();
        return signRule;
    }

    @Bean
    public SignManager signManager(List<SignRule> signRules, List<SignEncrypt> signEncrypts) {
        SignManager signManager = new SignManager();
        signManager.setSignEncrypts(signEncrypts);
        signManager.setSignRules(signRules);
        return signManager;
    }

}

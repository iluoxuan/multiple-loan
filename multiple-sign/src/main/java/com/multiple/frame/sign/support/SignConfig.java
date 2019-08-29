package com.multiple.frame.sign.support;

import com.multiple.frame.common.exception.ChannelSingException;
import lombok.Data;
import org.springframework.util.StringUtils;

/**
 * @author: junqing.li
 * @date: 2019/8/27
 */
@Data
public class SignConfig {

    /**
     * 规则
     *
     * @return
     */
    private String rule;

    /**
     * 算法
     *
     * @return
     */
    private String encrypt;

    /**
     * 排除的字段
     *
     * @return
     */
    private String exclude;

    /**
     * 我方私钥
     *
     * @return
     */
    private String privateKey;

    /**
     * 渠道方公钥
     *
     * @return
     */
    private String channelPublicKey;

    /**
     * 检查sign 配置
     */
    public void checkSignConfig() {

        if (!StringUtils.hasText(rule)) {
            throw new ChannelSingException("no sign rule config");
        }

        if (!StringUtils.hasText(encrypt)) {
            throw new ChannelSingException("no encrypt rule config");
        }
    }

}

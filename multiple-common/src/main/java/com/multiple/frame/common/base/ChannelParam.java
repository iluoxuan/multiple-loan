package com.multiple.frame.common.base;

import com.google.common.collect.Sets;
import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotEmpty;
import java.util.Set;

/**
 * @author: junqing.li
 * @date: 2019/8/27
 */
@Data
public class ChannelParam {

    /**
     * 渠道编码
     */
    @NotEmpty
    private String channelCode;

    /**
     * 业务模块
     */
    private String bizModel;

    /**
     * 执行的业务方法
     */
    private String bizMethod;

    /**
     * 渠道请求body
     */
    @NotEmpty
    private String requestBody;

    /**
     * 启用的拦截器
     */
    private Set<String> interceptorKeys = Sets.newHashSet();

    /**
     * 是 bodymethod 方式
     *
     * @return
     */
    public boolean isBodyMethod() {
        return StringUtils.isBlank(bizMethod);
    }


}

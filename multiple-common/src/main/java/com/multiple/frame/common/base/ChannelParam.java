package com.multiple.frame.common.base;

import lombok.Data;
import org.apache.commons.lang3.StringUtils;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

/**
 * @author: junqing.li
 * @date: 2019/8/27
 */
@Data
public class ChannelParam<T> {

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
    @NotNull
    private T requestBody;

    /**
     * 是 bodymethod 方式
     *
     * @return
     */
    public boolean isBodyMethod() {
        return StringUtils.isBlank(bizMethod);
    }


}

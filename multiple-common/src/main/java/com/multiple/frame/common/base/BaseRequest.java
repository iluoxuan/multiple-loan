package com.multiple.frame.common.base;

import lombok.Data;

/**
 * 基本请求
 * @author: junqing.li
 * @date: 2019/8/29
 */
@Data
public class BaseRequest {

    private String sign;

    private String data;

    private String time;

    private String appId;

    private String method;

}

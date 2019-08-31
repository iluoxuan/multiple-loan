package com.multiple.frame.gw.entity;

import lombok.Data;

/**
 * @author: junqing.li
 * @date: 2019/8/31
 */
@Data
public class RpcRequest<T> {

    private String channelCode;

    private String method;

    private T param;


}

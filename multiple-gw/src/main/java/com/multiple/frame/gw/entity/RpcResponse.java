package com.multiple.frame.gw.entity;

import lombok.Data;

/**
 * @author: junqing.li
 * @date: 2019/8/31
 */
@Data
public class RpcResponse<T> {

    private T data;

    private int code;



}

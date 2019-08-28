package com.multiple.frame.common.exception;

import lombok.Getter;

/**
 * @author: junqing.li
 * @date: 2019/7/10
 */
@Getter
public class ChannelException extends RuntimeException {

    private ErrorCode code;

    private ErrorCode nextCode;

    private String msg;

    public ChannelException() {
        super();
    }

    public ChannelException(String message) {
        super(message);
        this.msg = message;
    }

    public ChannelException(ErrorCode code) {
        super("");
        this.code = code;
    }

    public ChannelException(String message, ErrorCode code) {
        super(message);
        this.code = code;
    }

    public ChannelException(ErrorCode code, ErrorCode nextCode) {
        super("");
        this.code = code;
        this.nextCode = nextCode;
    }


    public ChannelException(String message, ErrorCode code, ErrorCode nextCode) {
        super(message);
        this.msg = message;
        this.code = code;
        this.nextCode = nextCode;
    }


    public ChannelException(Throwable cause) {
        super(cause);
    }
}

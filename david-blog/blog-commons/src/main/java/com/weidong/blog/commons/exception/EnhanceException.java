package com.weidong.blog.commons.exception;

/**
 * @ClassName EnhanceException
 * @Description TODO
 * @Author weidong
 * @email 1130160475@qq.com
 * @Date 2018/5/20 12:45
 * @Copyright Copyright (weidong) 2018
 * @Version 0.0.1
 **/
public class EnhanceException extends RuntimeException {

    public EnhanceException() {
    }

    public EnhanceException(String message) {
        super(message);
    }

    public EnhanceException(String message, Throwable cause) {
        super(message, cause);
    }

    public EnhanceException(Throwable cause) {
        super(cause);
    }

    public EnhanceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

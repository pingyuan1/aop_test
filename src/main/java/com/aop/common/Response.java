package com.aop.common;

import java.io.Serializable;

/**
 * @author ：pingyuan
 * @description：TODO
 * @date ：2021/6/10 10:11
 */
public  class Response<T> implements Serializable {

    private static final long serialVersionUID = -6072673470315259686L;

    private T data;
    private int code;
    private String message;

    public Response(){

    }
    public Response(T data){
        this.data = data;
    }
    public static <T> Response<T> success(T data){
        return new Response<>(data);
    }
    public T getT() {
        return data;
    }

    public void setT(T t) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}

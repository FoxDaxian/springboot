package com.example.demo.exception;

public class MyException extends RuntimeException {
    private String code;
    private String msg;

    public MyException(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode(){
        return this.code;
    }
    public String getMsg(){
        return this.msg;
    }
}

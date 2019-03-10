package com.netcracker.edu.backend.lab2.entity;

public class ErrorMsg {

    private String msg;

    public ErrorMsg() {
    }

    ErrorMsg(String msg) {
        this.msg = msg;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}

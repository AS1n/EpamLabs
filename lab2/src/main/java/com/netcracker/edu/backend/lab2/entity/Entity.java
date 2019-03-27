package com.netcracker.edu.backend.lab2.entity;

public class Entity {
    private boolean isEven;
    private boolean isSimple;
    private ErrorMsg errorMsg;

    public Entity() {
    }

    public Entity(boolean isEven, boolean isSimple) {
        this.isEven = isEven;
        this.isSimple = isSimple;
    }

    public Entity(String errorMsg) {
        this.errorMsg = new ErrorMsg(errorMsg);
    }

    public boolean isEven() {
        return isEven;
    }

    public void setEven(boolean even) {
        isEven = even;
    }

    public boolean isSimple() {
        return isSimple;
    }

    public void setSimple(boolean simple) {
        isSimple = simple;
    }

    public ErrorMsg getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(ErrorMsg errorMsg) {
        this.errorMsg = errorMsg;
    }

    @Override
    public String toString() {
        return "Entity{" +
                "isEven=" + isEven +
                ", isSimple=" + isSimple +
                ", errorMsg=" + errorMsg +
                '}';
    }
}

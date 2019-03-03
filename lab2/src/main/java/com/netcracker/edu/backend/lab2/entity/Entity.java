package com.netcracker.edu.backend.lab2.entity;

public class Entity {
    private boolean isEven;
    private boolean isSimple;

    public Entity() {
    }

    public Entity(boolean isEven, boolean isSimple) {
        this.isEven = isEven;
        this.isSimple = isSimple;
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
}

package com.netcracker.edu.backend.lab2.entity;


import java.util.ArrayList;

public class BulkData {
    private ArrayList<String> set;

    public BulkData() {
    }

    public ArrayList<String> getSet() {
        return set;
    }

    public void setSet(ArrayList<String> set) {
        this.set = set;
    }

    public BulkData(ArrayList<String> set) {
        this.set = set;
    }
}

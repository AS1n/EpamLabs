package com.netcracker.edu.backend.lab2.classes;

import com.netcracker.edu.backend.lab2.entity.ResEntity;

import java.util.ArrayList;

public class BulkResponse {
    private ArrayList<ResEntity> list;
    private Statistics statistics;

    public BulkResponse(ArrayList<ResEntity> list, Statistics statistics) {
        this.list = list;
        this.statistics = statistics;
    }

    public BulkResponse(ArrayList<ResEntity> list) {
        this.list = list;
    }

    public ArrayList<ResEntity> getList() {
        return list;
    }

    public Statistics getStatistics() {
        return statistics;
    }
}

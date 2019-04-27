package com.netcracker.edu.backend.lab2.service;

import com.netcracker.edu.backend.lab2.cache.Cache;
import com.netcracker.edu.backend.lab2.classes.*;
import com.netcracker.edu.backend.lab2.entity.ResEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Component
public class Service {

    private NumEntityService numEntityService;
    private Cache cache;

    private ExecutorService executor = Executors.newSingleThreadExecutor();

    @Autowired
    public Service(Cache cache, NumEntityService numEntityService) {
        this.cache = cache;
        this.numEntityService = numEntityService;
    }


    public Future<ArrayList<ResEntity>> calculate(BulkData nums) {
        return executor.submit(() -> {
            Thread.sleep(10000);
            ArrayList<ResEntity> entities = new ArrayList<>();
            nums.getSet().forEach(num -> entities.add(getEntity(num)));
            return entities;
        });
    }

    public Integer getEntityBulk(BulkData nums) {
        Future<ArrayList<ResEntity>> future = calculate(nums);
        cache.addToMap(future);

        return cache.getCurrentFutureId();
    }

    public ArrayList<ResEntity> getEntityFuture(Integer futureId){
        Future<ArrayList<ResEntity>> future = cache.getFuture(futureId);
        if(future.isDone()) {
            try {
                return future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public ResEntity getEntity(String num) {
        return numEntityService.getEntity(num);
    }

    public void initCache() {
        cache.initCache();
    }

    public Cache getCache() {
        return cache;
    }

}

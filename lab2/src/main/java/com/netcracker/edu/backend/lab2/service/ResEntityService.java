package com.netcracker.edu.backend.lab2.service;

import com.netcracker.edu.backend.lab2.cache.Cache;
import com.netcracker.edu.backend.lab2.entity.ResEntity;
import com.netcracker.edu.backend.lab2.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;

@Component
public class ResEntityService {

    private Cache cache;

    @Autowired
    public ResEntityService(Cache cache) {
        this.cache = cache;
    }

    public ResEntity getEntity(Long num) {
        ResEntity entity = new ResEntity(num);
        addToCacheMap(num, entity);
        return cache.getEntity(entity);
    }


    private void addToCacheMap(Long key, ResEntity value) {
        cache.add(key, value);
    }

    public HashMap<Long, ResEntity> getMap() {
        return this.cache.getMap();
    }

}

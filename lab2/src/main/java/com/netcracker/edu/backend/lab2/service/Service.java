package com.netcracker.edu.backend.lab2.service;

import com.netcracker.edu.backend.lab2.cache.CacheMap;
import com.netcracker.edu.backend.lab2.counter.Counter;
import com.netcracker.edu.backend.lab2.entity.BulkData;
import com.netcracker.edu.backend.lab2.entity.Entity;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.*;
import java.util.function.Predicate;

@Component
public class Service {

    private CacheMap map;
    private Counter counter;

    private static final Logger logger = Logger.getLogger(Service.class);

    @Autowired
    public Service(CacheMap map, Counter counter) {
        this.map = map;
        this.counter = counter;
    }

    public ArrayList<Entity> getEntityF(BulkData nums) {
        ArrayList<Entity> entities = new ArrayList<>();
        nums.getSet().forEach(num -> entities.add(getEntity(num)));
        return entities;
    }

    public Entity getEntity(String numS) {
        counter.inc();
        if(logger.isDebugEnabled()){
            logger.debug("getEntity method is called!");
        }
        if(numS==null) {
            return isError("Invalid params! Need parameter num");
        }
        int num;
        try {
            num = Integer.parseInt(numS);
        } catch (NumberFormatException e) {
            return isError("Invalid params! Param num must be an int number");
        }

        if(num<2) {
            return isError("Invalid params! Param num must be > 2");
        }

        logger.debug("getEntity method is successfully completed");
        if(map.get(num)!=null) {
            return map.get(num);
        }

        Entity entity = new Entity(getEven(num), getSimple(num));
        addToCacheMap(num, entity);
        return entity;
    }

    private void addToCacheMap(Integer key, Entity value) {
        if(map.getMap().get(key)==null)
            map.add(key, value);
    }

    public HashMap<Integer, Entity> getCacheMap() {
        return map.getMap();
    }

    public Integer getCount() {
        return counter.getCount();
    }

    private boolean getEven(int num) {
        return num % 2 == 0;
    }

    private boolean getSimple(int num) {
        for(int i = 2; i < Math.sqrt(num); i++) {
            if(num%i==0)
                return false;
        }
        return true;
    }

    private static Boolean getSimpleF(Integer num, Predicate<Integer> predicate) {
        return predicate.test(num);
    }

    private Entity isError(String msg) {
        logger.error(msg);
        return new Entity(msg);
    }

}

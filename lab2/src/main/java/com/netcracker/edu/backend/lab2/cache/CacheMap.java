package com.netcracker.edu.backend.lab2.cache;

import com.netcracker.edu.backend.lab2.entity.Entity;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Objects;

@Component
public class CacheMap {

    private static final Logger logger = Logger.getLogger(CacheMap.class);
    private HashMap<Integer, Entity> map = new HashMap<>();

    public void add(Integer key, Entity value) {
        if(this.map.isEmpty())
            logger.info("CacheMap has created.");
        this.map.put(key, value);
        logger.info("Entity " + value + " added to CacheMap with key " + key);
    }

    public Entity get(Integer key) {
        return this.map.get(key);
    }

    public HashMap<Integer, Entity> getMap() {
        return map;
    }

    public CacheMap() { }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CacheMap cacheMap = (CacheMap) o;
        return Objects.equals(map, cacheMap.map);
    }

    @Override
    public int hashCode() {
        return Objects.hash(map);
    }
}

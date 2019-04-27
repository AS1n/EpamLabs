package com.netcracker.edu.backend.lab2.cache;

import com.netcracker.edu.backend.lab2.entity.ResEntity;
import com.netcracker.edu.backend.lab2.repository.EntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Objects;
import java.util.concurrent.Future;

@Component
public class Cache {

    private ArrayList<ResEntity> entities;
    private HashMap<Long, ResEntity> map = new HashMap<>();
    private HashMap<Integer, Future<ArrayList<ResEntity>>> futures = new HashMap<>();

    private Integer currentFutureId = 0;

    private EntityRepository repository;

    @Autowired
    public Cache(EntityRepository repository) {
        this.repository = repository;
    }

    public void initCache() {
        initEntities();
    }

    private void generateFutureId() {
        if(currentFutureId > 100 || currentFutureId < 0) {
            currentFutureId = 0;
        } else currentFutureId++;
    }

    private void initEntities() {
        this.entities = (ArrayList<ResEntity>) repository.findAll();
    }

    public ResEntity getEntity(ResEntity entity) {
        if(entities==null)
            initEntities();
        return entities.stream().filter(ent ->
                ent.isEven()==entity.isEven() && ent.isSimple()==entity.isSimple())
                .findFirst().get();
    }

    public void addToMap(Future<ArrayList<ResEntity>> future) {
        generateFutureId();
        this.futures.put(this.currentFutureId, future);
    }

    public Future<ArrayList<ResEntity>> getFuture(Integer futureId) {
        return this.futures.get(futureId);
    }

    public void add(Long key, ResEntity value) {
        if (this.map.get(key) != null)
            return;
        this.map.put(key, value);
    }

    public ResEntity get(Long key) {
        return this.map.get(key);
    }

    public HashMap<Long, ResEntity> getMap() {
        return map;
    }

    public ArrayList<ResEntity> getEntities() {
        return entities;
    }

    public HashMap<Integer, Future<ArrayList<ResEntity>>> getFutures() {
        return futures;
    }

    public Integer getCurrentFutureId() {
        return currentFutureId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cache cache = (Cache) o;
        return Objects.equals(entities, cache.entities) &&
                Objects.equals(map, cache.map) &&
                Objects.equals(futures, cache.futures) &&
                Objects.equals(currentFutureId, cache.currentFutureId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(entities, map, futures, currentFutureId);
    }
}

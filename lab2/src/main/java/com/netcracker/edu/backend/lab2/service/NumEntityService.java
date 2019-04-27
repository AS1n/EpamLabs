package com.netcracker.edu.backend.lab2.service;

import com.netcracker.edu.backend.lab2.cache.Cache;
import com.netcracker.edu.backend.lab2.entity.NumEntity;
import com.netcracker.edu.backend.lab2.entity.ResEntity;
import com.netcracker.edu.backend.lab2.repository.NumEntityRepository;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Component
public class NumEntityService {

    private NumEntityRepository repository;
    private ResEntityService resEntityService;
    private final Cache cache;

    private static final Logger logger = Logger.getLogger(Service.class);

    @Autowired
    public NumEntityService(NumEntityRepository repository, ResEntityService resEntityService, Cache cache) {
        this.repository = repository;
        this.resEntityService = resEntityService;
        this.cache = cache;
    }

    public ResEntity getEntity(String numS) {

        if (numS == null) {
            return isError("Invalid params! Need parameter num");
        }
        Long num;
        try {
            num = Long.parseLong(numS);
        } catch (NumberFormatException e) {
            return isError("Invalid params! Param num must be an int number");
        }

        if (num < 2) {
            return isError("Invalid params! Param num must be > 2");
        }

        logger.debug("getEntity method is successfully completed");
        if (cache.get(num) != null) {
            return cache.get(num);
        }

        Optional<NumEntity> entity = repository.findByNum(num);
        if(entity.isPresent())
            return entity.get().getEntity();
        ResEntity ans = resEntityService.getEntity(num);
        repository.save(new NumEntity(num, ans));
        return ans;
    }


    private ResEntity isError(String msg) {
        logger.error(msg);
        return null;
    }

}

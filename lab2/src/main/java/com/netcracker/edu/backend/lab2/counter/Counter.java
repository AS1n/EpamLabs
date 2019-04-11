package com.netcracker.edu.backend.lab2.counter;

import com.netcracker.edu.backend.lab2.cache.CacheMap;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Counter {

    private static final Logger logger = Logger.getLogger(CacheMap.class);
    private Integer count = 0;


    public synchronized void inc() {
        count++;
        logger.info("Counter updated. Current value: " + count);
    }

    public Integer getCount() {
        return count;
    }

    public Counter() {
    }
}

package com.netcracker.edu.backend.lab2.controller;

import com.netcracker.edu.backend.lab2.cache.Cache;
import com.netcracker.edu.backend.lab2.classes.BulkData;
import com.netcracker.edu.backend.lab2.entity.ResEntity;
import com.netcracker.edu.backend.lab2.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/controller")
public class Controller {

    private Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @RequestMapping
    public ResponseEntity<ResEntity> getEntity(
            @RequestParam(name = "num", required = false) String numS
    ) {
        return ResponseEntity.ok(service.getEntity(numS));
    }

    @RequestMapping("/future")
    public ResponseEntity<?> getEntityBulk(
            @RequestParam(name = "future_id") Integer futureId
    ) {
        ArrayList<ResEntity> entities = service.getEntityFuture(futureId);
        if(entities==null)
            return ResponseEntity.ok("This operation is still computing. Try a bit later.");
        return ResponseEntity.ok(entities);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Integer> getEntityFuture(
            @RequestBody BulkData nums
    ) {
        return ResponseEntity.ok(service.getEntityBulk(nums));
    }



    @RequestMapping(value = "/cache")
    public ResponseEntity<Cache> getCache() {
        return ResponseEntity.ok(service.getCache());
    }

    @RequestMapping(value = "/cache/init")
    public void getCount() {
        service.initCache();
    }

}

package com.netcracker.edu.backend.lab2.controller;

import com.netcracker.edu.backend.lab2.entity.BulkData;
import com.netcracker.edu.backend.lab2.entity.Entity;
import com.netcracker.edu.backend.lab2.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/api/controller")
public class Controller {

    private Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @RequestMapping
    public ResponseEntity<Entity> getEntity(
            @RequestParam(name = "num", required = false) String numS
    ) {
        Entity entity = service.getEntity(numS);
        if(entity.getErrorMsg()!=null)
            return ResponseEntity.status(400).body(entity);
        return ResponseEntity.ok(entity);
    }

    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<ArrayList<Entity>> getEntityF(
            @RequestBody BulkData nums
    ) {
        ArrayList<Entity> list = service.getEntityF(nums);
        return ResponseEntity.ok(list);
    }

    @RequestMapping(value = "/cache")
    public ResponseEntity<HashMap<Integer, Entity>> getCache() {
        return ResponseEntity.ok(service.getCacheMap());
    }

    @RequestMapping(value = "/count")
    public ResponseEntity<Integer> getCount() {
        return ResponseEntity.ok(service.getCount());
    }

}

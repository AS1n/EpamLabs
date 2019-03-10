package com.netcracker.edu.backend.lab2.controller;

import com.netcracker.edu.backend.lab2.entity.Entity;
import com.netcracker.edu.backend.lab2.service.Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/controller")
public class Controller {

    private Service service;

    @Autowired
    public Controller(Service service) {
        this.service = service;
    }

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Entity> getEntity(
            @RequestParam(name = "num", required = false) String numS
    ) {

        Entity entity = service.getEntity(numS);
        if(entity.getErrorMsg()!=null)
            return ResponseEntity.status(400).body(entity);
        return ResponseEntity.ok(entity);
    }


}

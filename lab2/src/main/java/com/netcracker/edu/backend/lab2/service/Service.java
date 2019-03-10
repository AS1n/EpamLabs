package com.netcracker.edu.backend.lab2.service;

import com.netcracker.edu.backend.lab2.controller.Controller;
import com.netcracker.edu.backend.lab2.entity.Entity;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class Service {

    private static final Logger logger = Logger.getLogger(Controller.class);

    public Entity getEntity(String numS) {

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
            return isError("Invalid params! Param num must be a number");
        }

        if(num<2) {
            return isError("Invalid params! Param num must be > 2");
        }

        logger.debug("getEntity method is successfully completed");
        return new Entity(getEven(num), getSimple(num));
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

    private Entity isError(String msg) {
        logger.error(msg);
        return new Entity(msg);
    }

}

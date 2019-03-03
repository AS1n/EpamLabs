package com.netcracker.edu.backend.lab1.service;

import org.springframework.stereotype.Component;

@Component
public class Service {

    public boolean getEven(int num) {
        return num % 2 == 0;
    }

    public boolean getSimple(int num) {
        for(int i = 2; i < Math.sqrt(num); i++) {
            if(num%i==0)
                return false;
        }
        return true;
    }

}

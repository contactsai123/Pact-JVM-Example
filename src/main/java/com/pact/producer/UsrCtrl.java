package com.pact.producer;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class UsrCtrl {



    @RequestMapping("/user/{name}/{empid}")
    public UsrInfo bus(@PathVariable String name, @PathVariable String empid) {
        int salary = getEtaBasedOnGpsAndOtherAdcancedStuff();
        int age = 30;
        UsrInfo b = new UsrInfo(name, empid, age, salary);
        return b;
    }

    private int getEtaBasedOnGpsAndOtherAdcancedStuff() {
        Random rn = new Random();
        int min = 50000;
        int max = 70000;
        return rn.nextInt(max - min + 5000) + min;
    }


}

// http://localhost:8111/user/Peter/214
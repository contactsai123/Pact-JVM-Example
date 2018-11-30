package com.pact.producer;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
public class UsrCtrl {

    @RequestMapping("/user/{legalname}/{empid}")
    public UsrInfo bus(@PathVariable String legalname, @PathVariable String empid) {
        int salary = getSalary();
        int age = 30;
        UsrInfo b = new UsrInfo(legalname, empid, age, salary);
        return b;
    }

    private int getSalary() {
        Random rn = new Random();
        int min = 50000;
        int max = 70000;
        return rn.nextInt(max - min + 5000) + min;
    }


}

// http://localhost:8111/user/Peter/214
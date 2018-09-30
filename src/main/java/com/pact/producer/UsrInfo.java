package com.pact.producer;

/**
 * Created by set842 on 29/11/17.
 */
public class UsrInfo {
    String name;
    String empid;
    Integer age;
    Integer salary;


    public UsrInfo(String name, String empid, Integer age, Integer salary) {
        this.name=name;
        this.empid = empid;
        this.age=age;
        this.salary = salary;
    }
    
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmpid() {
        return empid;
    }

    public void setEmpid(String empid) {
        this.empid = empid;
    }

    public Integer getSalary() {
        return salary;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setStation(String name) {
        this.name = name;
    }
}

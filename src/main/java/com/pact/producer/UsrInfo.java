package com.pact.producer;

public class UsrInfo {
    String legalname;
    String empid;
    Integer age;
    Integer salary;


    public UsrInfo(String legalname, String empid, Integer age, Integer salary) {
        this.legalname=legalname;
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

    public String getlegalname() {
        return legalname;
    }

    public void setlegalname(String legalname) {
        this.legalname = legalname;
    }
}

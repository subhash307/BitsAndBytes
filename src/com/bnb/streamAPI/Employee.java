package com.bnb.streamAPI;

import java.util.Date;

public class Employee {
    private String name;
    private Double salary;
    private Date joiningDate;
    private String gender;

    public Employee(String name, Double salary, Date joiningDate, String gender) {
        this.name = name;
        this.salary = salary;
        this.joiningDate = joiningDate;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Date getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(Date joiningDate) {
        this.joiningDate = joiningDate;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", salary=" + salary +
                ", joiningDate=" + joiningDate +
                ", gender='" + gender + '\'' +
                '}';
    }
}

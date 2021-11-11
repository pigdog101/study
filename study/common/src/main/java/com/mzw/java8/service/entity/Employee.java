package com.mzw.java8.service.entity;

import java.util.Objects;

/**
 * @PACKAGE_NAME: com.mzw.lambda.service.entity
 * @AUTHOR: mzw
 * @DATE: 2021/1/17
 */
public class Employee {
    private Integer age;
    private String name;
    private Double salary;
    private Status status;
    public Employee(Integer age, String name, Double salary) {
        this.age = age;
        this.name = name;
        this.salary = salary;
    }

    public Employee(Integer age, String name, Double salary, Status status) {
        this.age = age;
        this.name = name;
        this.salary = salary;
        this.status = status;
    }

    public Employee(Integer age) {
        this.age = age;
    }

    public Employee(Integer age, String name) {
        this.age = age;
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public Employee() {
    }

    public void setAge(Integer age) {
        this.age = age;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(age, employee.age) &&
                Objects.equals(name, employee.name) &&
                Objects.equals(salary, employee.salary) &&
                status == employee.status;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", salary=" + salary +
                ", status=" + status +
                '}';
    }

    @Override
    public int hashCode() {
        return Objects.hash(age, name, salary);
    }

}


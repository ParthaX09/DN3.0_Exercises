package com.springorm.employeemanagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_tbl")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    private String name;
    private String email;
    private double salary;
    @ManyToOne
    private Department department;

    public Employee(int id, String name, String email, double salary,Department department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.salary=salary;
        this.department = department;
    }

    public Employee() {

    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}

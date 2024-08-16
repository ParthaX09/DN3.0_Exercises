package com.springorm.employeemanagementsystem.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "employee_tbl")
@NamedQueries(
        {
                @NamedQuery(name = "Employee.findCity",
                query = "SELECT e FROM Employee e WHERE e.city =:city"
                )
        }
)
public class Employee extends Auditable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    private String name;
    private String email;
    private String city;
    private double salary;
    @ManyToOne
    private Department department;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }



    public Employee(int id, String name, String email,String city,double salary, Department department) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.city=city;
        this.salary=salary;
        this.department = department;
    }

    public Employee() {

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

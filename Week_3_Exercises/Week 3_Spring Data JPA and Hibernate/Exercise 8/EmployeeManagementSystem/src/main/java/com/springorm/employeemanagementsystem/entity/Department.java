package com.springorm.employeemanagementsystem.entity;

import jakarta.persistence.*;
import org.springframework.context.annotation.Configuration;

@Entity
@Table(name = "department_tbl")
@NamedQueries(
        {
                @NamedQuery(name = "Department.findByName",
                        query = "SELECT d FROM Department d WHERE d.name = :name"),
                @NamedQuery(name="Department.findNameLike",
                        query = "SELECT d from Department d WHERE d.name LIKE '%developer%'")
        }
)
public class Department extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;

    public Department(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public Department() {

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
}

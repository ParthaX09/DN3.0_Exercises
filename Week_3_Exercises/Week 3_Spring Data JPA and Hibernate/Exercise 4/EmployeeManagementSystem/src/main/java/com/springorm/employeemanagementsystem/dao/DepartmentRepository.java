package com.springorm.employeemanagementsystem.dao;

import com.springorm.employeemanagementsystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    public List<Department> findDepartmentByName(String name);
    public Department findDepartmentById(int id);
}

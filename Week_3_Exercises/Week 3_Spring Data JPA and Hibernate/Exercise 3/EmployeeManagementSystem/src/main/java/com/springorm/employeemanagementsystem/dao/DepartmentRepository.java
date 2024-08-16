package com.springorm.employeemanagementsystem.dao;

import com.springorm.employeemanagementsystem.entity.Department;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department,Integer>{
    public List<Department> findDepartmentByName(String name);
    public Department findDepartmentById(int id);
}

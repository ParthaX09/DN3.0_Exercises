package com.springorm.employeemanagementsystem.dao;

import com.springorm.employeemanagementsystem.entity.Department;
import com.springorm.employeemanagementsystem.entity.Employee;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<Employee,Integer>{
    public Employee findEmployeeById(int id);
    public List<Employee> findEmployeeByDepartment(Department department);
    public List<Employee> findEmployeeByDepartmentAndName(Department department, String name);
}

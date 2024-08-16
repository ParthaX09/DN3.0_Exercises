package com.springorm.employeemanagementsystem.dao;

import com.springorm.employeemanagementsystem.entity.Department;
import com.springorm.employeemanagementsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    public Employee findEmployeeById(int id);
    public List<Employee> findEmployeeByDepartment(Department department);
    public Employee findEmployeeByEmailAndName(String email, String name);
}

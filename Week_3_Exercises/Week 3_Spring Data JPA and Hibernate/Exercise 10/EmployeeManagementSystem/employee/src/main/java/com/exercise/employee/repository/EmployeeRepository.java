package com.exercise.employee.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.exercise.employee.dao.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // Custom query methods
    List<Employee> findByName(String name);

    List<Employee> findByEmail(String email);

    List<Employee> findByNameStartingWith(String name);

    @Query("from Employee where name like %:substring%")
    List<Employee> findEmployeesByNameContaining(@Param("substring") String substring);

    @Query(name = "Employee.findByDepartmentName")
    List<Employee> findByDepartmentName(@Param("departmentName") String departmentName);

}

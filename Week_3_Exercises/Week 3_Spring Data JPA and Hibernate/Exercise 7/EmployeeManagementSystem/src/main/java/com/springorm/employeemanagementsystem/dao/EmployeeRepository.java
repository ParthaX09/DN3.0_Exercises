package com.springorm.employeemanagementsystem.dao;

import com.springorm.employeemanagementsystem.entity.Department;
import com.springorm.employeemanagementsystem.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
    public Employee findEmployeeById(int id);
    public List<Employee> findEmployeeByDepartment(Department department);
    public Employee findEmployeeByEmailAndName(String email, String name);
    @Query("select e from Employee e where e.salary >:salary")
    public List<Employee> getEmployeeAboveSalary(@Param("salary") double salary);
    @Query(name="Employee.findCity")
    public List<Employee> findCity(@Param("city") String city);
}

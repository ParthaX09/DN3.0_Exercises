package com.springorm.employeemanagementsystem.controllers;

import com.springorm.employeemanagementsystem.EmployeeManagementSystemApplication;
import com.springorm.employeemanagementsystem.dao.EmployeeRepository;
import com.springorm.employeemanagementsystem.entity.Department;
import com.springorm.employeemanagementsystem.entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employee")
    public List<Employee> getEmployees(){
        return employeeRepository.findAll();
    }

    @GetMapping("/employee/id/{id}")
    public Employee getEmployeeById(@PathVariable int id){
        return employeeRepository.findEmployeeById(id);
    }
    @GetMapping("/employee/email/{email}/name/{name}")
    public Employee getEmployeeByEmailAndName(@PathVariable String email,@PathVariable String name){
        return employeeRepository.findEmployeeByEmailAndName(email,name);
    }

    @PostMapping("/employee")
    public Employee createEmployee(@RequestBody Employee employee){
        return employeeRepository.save(employee);
    }

    @PutMapping("/employee/id/{id}")
    public Employee updateEmployee(@PathVariable int id,@RequestBody Employee employee){
        employee.setId(id);
        return employeeRepository.save(employee);
    }


    @DeleteMapping("/employee/id/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeRepository.deleteById(id);
    }
}

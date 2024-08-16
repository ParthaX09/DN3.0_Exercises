package com.springorm.employeemanagementsystem.controllers;

import com.springorm.employeemanagementsystem.EmployeeManagementSystemApplication;
import com.springorm.employeemanagementsystem.dao.EmployeeRepository;
import com.springorm.employeemanagementsystem.dto.EmployeeEmailDto;
import com.springorm.employeemanagementsystem.entity.Department;
import com.springorm.employeemanagementsystem.entity.Employee;
import com.springorm.employeemanagementsystem.projections.EmployeeNameAndSalary;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeRepository employeeRepository;

    @GetMapping("/employee")
    public List<Employee> getEmployees(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection
    ){
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Employee> empPage=employeeRepository.findAll(pageable);
        return empPage.getContent();
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
    @GetMapping("/employee/custom/{salary}")
    public List<Employee> salaryGreaterThan(@PathVariable double salary){
        return employeeRepository.getEmployeeAboveSalary(salary);
    }

    @GetMapping("/employee/custom/city/{city}")
    public List<Employee> findEmployeeByCity(@PathVariable String city){
        return employeeRepository.findCity(city);
    }

    @GetMapping("/employee/projection/city/{city}")
    public List<EmployeeNameAndSalary> findEmployeeCity(@PathVariable("city") String city)
    {
        return employeeRepository.findEmployeeByCity(city);
    }
    @GetMapping("/employee/projection/name/{prefix}")
    public List<EmployeeEmailDto> getEmployeeNameAndEmail(@PathVariable("prefix") String prefix){
        return employeeRepository.findEmployeeByNameStartingWith(prefix);
    }
}

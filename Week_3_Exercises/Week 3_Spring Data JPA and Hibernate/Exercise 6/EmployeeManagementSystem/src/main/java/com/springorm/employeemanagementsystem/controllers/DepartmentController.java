package com.springorm.employeemanagementsystem.controllers;

import com.springorm.employeemanagementsystem.dao.DepartmentRepository;
import com.springorm.employeemanagementsystem.entity.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DepartmentController {
    @Autowired
    private DepartmentRepository departmentRepository;
    @PostMapping("/department")
    public Department createDepartment(@RequestBody Department department){
        return departmentRepository.save(department);
    }
    @GetMapping("/department")
    public List<Department> getDepartments(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "5") int size,
            @RequestParam(defaultValue = "name") String sortBy,
            @RequestParam(defaultValue = "asc") String sortDirection
    ){
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortBy).ascending() :
                Sort.by(sortBy).descending();

        Pageable pageable = PageRequest.of(page, size, sort);
        Page<Department> depPage=departmentRepository.findAll(pageable);
        return depPage.getContent();
    }
    @GetMapping("/department/id/{id}")
    public Department getDepartmentById(@PathVariable int id){
        return departmentRepository.findDepartmentById(id);
    }
    @DeleteMapping("/department/id/{id}")
    public void deleteDepartmentById(@PathVariable int id){
        departmentRepository.deleteById(id);
    }
    @GetMapping("/department/name/{name}")
    public List<Department> getDepartmentByName(@PathVariable String name){
        return departmentRepository.findDepartmentByName(name);
    }
    @PutMapping("/department/id/{id}")
    public Department updateDepartmentById(@PathVariable int id,@RequestBody Department department){
        department.setId(id);
        return departmentRepository.save(department);
    }

    @GetMapping("/department/custom/name/{name}")
    public List<Department> getByName(@PathVariable String name){
        return departmentRepository.findByName(name);
    }
    @GetMapping("/department/custom/developer")
    public List<Department> getDepartmentDeveloper(){
        return departmentRepository.findDepartmentNameContainingDeveloper();
    }

}

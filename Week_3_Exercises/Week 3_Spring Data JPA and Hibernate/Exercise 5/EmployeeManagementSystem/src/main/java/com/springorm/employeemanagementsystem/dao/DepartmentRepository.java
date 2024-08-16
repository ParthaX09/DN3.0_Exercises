package com.springorm.employeemanagementsystem.dao;

import com.springorm.employeemanagementsystem.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DepartmentRepository extends JpaRepository<Department,Integer> {
    public List<Department> findDepartmentByName(String name);
    public Department findDepartmentById(int id);
    @Query(name = "Department.findByName")
    public List<Department> findByName(@Param("name") String name);
    @Query(name="Department.findNameLike")
    public List<Department> findDepartmentNameContainingDeveloper();
}

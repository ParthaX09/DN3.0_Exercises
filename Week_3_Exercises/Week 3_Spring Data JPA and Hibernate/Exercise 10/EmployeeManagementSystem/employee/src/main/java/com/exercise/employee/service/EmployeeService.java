package com.exercise.employee.service;

import com.exercise.employee.dao.Employee;
import com.exercise.employee.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Transactional
    public void saveEmployeesInBatch(List<Employee> employees) {
        final int batchSize = 50;
        for (int i = 0; i < employees.size(); i++) {
            employeeRepository.save(employees.get(i));
            if (i > 0 && i % batchSize == 0) {
                employeeRepository.flush();
            }
        }
    }
}

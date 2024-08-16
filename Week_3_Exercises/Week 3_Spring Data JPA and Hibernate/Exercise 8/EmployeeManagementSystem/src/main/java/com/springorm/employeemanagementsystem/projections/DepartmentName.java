package com.springorm.employeemanagementsystem.projections;

import org.springframework.beans.factory.annotation.Value;

public interface DepartmentName {
    @Value("#{target.name}")
    String getName();
}

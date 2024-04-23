package com.example.baikiemtra.service.impl;

import com.example.baikiemtra.model.Department;
import com.example.baikiemtra.repository.IDepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DepartmentService {
    @Autowired
    private IDepartmentRepository departmentRepository;
    public Iterable<Department> findAll() {
        return departmentRepository.findAll();
    }
}

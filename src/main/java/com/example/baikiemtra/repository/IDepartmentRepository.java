package com.example.baikiemtra.repository;

import com.example.baikiemtra.model.Department;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDepartmentRepository extends CrudRepository<Department, Integer> {

}

package com.example.baikiemtra.repository;

import com.example.baikiemtra.model.Employee;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmployeeRepository extends CrudRepository<Employee, Integer> {

}

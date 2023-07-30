package com.EmployeeProject.EmployeeManagement.repository;

import org.springframework.data.repository.CrudRepository;
import com.EmployeeProject.EmployeeManagement.entity.EmployeeEntity;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {

}
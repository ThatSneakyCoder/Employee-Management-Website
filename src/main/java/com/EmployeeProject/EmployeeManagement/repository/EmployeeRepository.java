package com.EmployeeProject.EmployeeManagement.repository;

import org.springframework.data.repository.CrudRepository;
import com.EmployeeProject.EmployeeManagement.entity.EmployeeEntity;

import java.util.List;

public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Integer> {
    List<EmployeeEntity> findAllByOwnerId(Long ownerId);
}
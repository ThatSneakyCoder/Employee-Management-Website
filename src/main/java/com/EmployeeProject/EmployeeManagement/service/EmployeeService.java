package com.EmployeeProject.EmployeeManagement.service;

import com.EmployeeProject.EmployeeManagement.entity.EmployeeEntity;
import com.EmployeeProject.EmployeeManagement.entity.OwnerEntity;
import com.EmployeeProject.EmployeeManagement.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public List<EmployeeEntity> getAllEmployees() {
        Iterable<EmployeeEntity> employees = employeeRepository.findAll();
        List<EmployeeEntity> employeeList = new ArrayList<>();
        employees.forEach(employeeList::add);
        return employeeList;
    }

    public EmployeeEntity saveEmployee(EmployeeEntity employee) {
        return employeeRepository.save(employee);
    }

//    public List<EmployeeEntity> findEmployeesByOwner(OwnerEntity owner) {
//        List<EmployeeEntity> employeeList = new ArrayList<>();
//
//    }
}


package com.EmployeeProject.EmployeeManagement.service;

import com.EmployeeProject.EmployeeManagement.entity.OwnerEntity;
import com.EmployeeProject.EmployeeManagement.repository.OwnerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class OwnerService {

    @Autowired
    private OwnerRepository ownerRepository;

    public List<OwnerEntity> getAllOwners() {
        Iterable<OwnerEntity> owners = ownerRepository.findAll();
        List<OwnerEntity> ownerlist = new ArrayList<>();
        owners.forEach(ownerlist::add);
        return ownerlist;
    }

    public OwnerEntity saveOwner(OwnerEntity owner) {
        return ownerRepository.save(owner);
    }

    // more methods as per your requirements...
}

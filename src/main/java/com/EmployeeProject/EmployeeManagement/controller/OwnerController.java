package com.EmployeeProject.EmployeeManagement.controller;

import com.EmployeeProject.EmployeeManagement.entity.OwnerEntity;
import com.EmployeeProject.EmployeeManagement.service.OwnerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Controller
public class OwnerController {

    @GetMapping("/register.html")
    public String register(Model model) {
        model.addAttribute("message", "Shubh's Employee Management System");
        return "register";
    }

@Controller
@RequestMapping("/api")
class OwnerApiController {

    @Autowired
    private OwnerService ownerService;

    @GetMapping("/owners")
    public ResponseEntity<List<OwnerEntity>> getAllOwners() {
        List<OwnerEntity> owners = ownerService.getAllOwners();
        return ResponseEntity.ok(owners);
    }

    @PostMapping("/owners")
    public String saveOwner(@RequestParam String name, @RequestParam String email, @RequestParam Long id) {
        OwnerEntity owner = new OwnerEntity();
        owner.setName(name);
        owner.setId(id);
        owner.setEmail(email);
        ownerService.saveOwner(owner);
        return "index";
    }
}
}

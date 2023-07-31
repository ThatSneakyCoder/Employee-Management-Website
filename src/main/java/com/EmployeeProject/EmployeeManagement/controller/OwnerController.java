package com.EmployeeProject.EmployeeManagement.controller;

import com.EmployeeProject.EmployeeManagement.entity.EmployeeEntity;
import com.EmployeeProject.EmployeeManagement.entity.OwnerEntity;
import com.EmployeeProject.EmployeeManagement.service.EmployeeService;
import com.EmployeeProject.EmployeeManagement.service.OwnerService;
import jakarta.servlet.http.HttpSession;
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
import java.util.Optional;

@Controller
public class OwnerController {

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/register.html")
    public String register() {
        return "register";
    }

    @GetMapping("/database.html")
    public String database() {
        return "database";
    }

@GetMapping("/employee_data")
public String employeeData(HttpSession session, Model model) {
    Long ownerId = (Long) session.getAttribute("ownerId");  // retrieve ownerId from the session
    Optional<OwnerEntity> owner = ownerService.getOwnerById(ownerId);
    if (owner.isPresent()) {
        model.addAttribute("ownerName", owner.get().getName());  // add owner name to the model
        List<EmployeeEntity> employees = employeeService.getAllEmployeesByOwnerId(ownerId);  // get employees of this owner
        model.addAttribute("employees", employees);  // add employees to the model
    }
    model.addAttribute("ownerId", ownerId);  // add ownerId to the model
    return "employee_data";
}


}


@Controller
@RequestMapping("/api")
class OwnerApiController {

    @Autowired
    private OwnerService ownerService;

    @Autowired
    private EmployeeService employeeService;

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

    @PostMapping("/owner-login")
    public String ownerLogin(@RequestParam Long id, HttpSession session) {
        session.setAttribute("ownerId", id);
        List<EmployeeEntity> employees = employeeService.getAllEmployees();
        session.setAttribute("employees", employees);
        return "redirect:/employee_data";
    }

}



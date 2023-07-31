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

@Controller
public class OwnerController {

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
        List<EmployeeEntity> employees = (List<EmployeeEntity>) session.getAttribute("employees");
        model.addAttribute("employees", employees);
        return "employee_data";
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

//    @PostMapping("/owner-login")
//    public String authenticateOwnerAndFetchEmployees(@RequestParam Long id, Model model) {
//        OwnerEntity owner = ownerService.findOwnerById(id);
//
//         if (owner == null) {
//            model.addAttribute("error", "Owner not found");
//            return "owner-login";
//        } else {
//            List<EmployeeEntity> employees = employeeService.findEmployeesByOwner(owner);
//            model.addAttribute("employees", employees);
//            return "employees-view";
//        }
//    }

    @PostMapping("/owner-login")
    public String ownerLogin(@RequestParam Long id, HttpSession session) {
    // Here, you can authenticate the owner by id
    // And fetch the employee data
    List<EmployeeEntity> employees = employeeService.getAllEmployees();
    session.setAttribute("employees", employees);

    // Redirect to the employee_data page
    return "redirect:/employee_data";
}
//
//    @GetMapping("/display-employees")
//    public String displayAllEmployees(Model model) {
//        // Get all employees from the database
//        List<EmployeeEntity> employees = employeeService.getAllEmployees();
//
//        // Add employees to the model
//        model.addAttribute("employees", employees);
//
//        // Return the name of the view to display the employees
//        return "employees-view";
//    }
}
}

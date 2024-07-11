package com.employee.Employee.Management.System.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {

    @GetMapping("/home")
    public String home(){
        return "Welcome to employee management system";
    }
}

package com.employee.Employee.Management.System.Controller;

import com.employee.Employee.Management.System.Dto.EmployeeRequest;
import com.employee.Employee.Management.System.Entity.Employee;
import com.employee.Employee.Management.System.Exception.EmployeeNotFoundException;
import com.employee.Employee.Management.System.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/home")
    public String home(){
        return "Welcome to employee management system";
    }

    @PostMapping("/api/create-employee")
    public Employee createEmployee(@RequestBody @Valid EmployeeRequest employeeRequest){
        return employeeService.createNewEmployee(employeeRequest);
    }

    @GetMapping("/api/all-employees")
    public List<Employee> getEmployees(){
        return employeeService.getAllEmployees();
    }

    @PutMapping("/api/edit-employee")
    public Employee updateEmployee(@RequestBody @Valid EmployeeRequest employeeRequest) throws EmployeeNotFoundException {
        return employeeService.editEmployee(employeeRequest);
    }
}

package com.employee.Employee.Management.System.Controller;

import com.employee.Employee.Management.System.Dto.EmployeeRequest;
import com.employee.Employee.Management.System.Entity.Employee;
import com.employee.Employee.Management.System.Exception.EmployeeNotFoundException;
import com.employee.Employee.Management.System.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
    public ResponseEntity<Employee> createEmployee(@RequestBody @Valid EmployeeRequest employeeRequest){
        Employee createdEmployee=employeeService.createNewEmployee(employeeRequest);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @GetMapping("/api/all-employees")
    public ResponseEntity<List<Employee>> getEmployees(){
        List<Employee> allEmployees = employeeService.getAllEmployees();
        return ResponseEntity.status(HttpStatus.OK).body(allEmployees);
    }

    @PutMapping("/api/edit-employee")
    public ResponseEntity<Employee> updateEmployee(@RequestBody @Valid EmployeeRequest employeeRequest) throws EmployeeNotFoundException {
        Employee updatedEmployee=employeeService.editEmployee(employeeRequest);
        return ResponseEntity.status(HttpStatus.OK).body(updatedEmployee);
    }

    @DeleteMapping("/api/delete-employee")
    public ResponseEntity<String> deleteEmployee(@RequestParam long employeeId) throws EmployeeNotFoundException {
        employeeService.removeEmployee(employeeId);
        return ResponseEntity.status(HttpStatus.OK).body("Employee deleted successfully");
    }
}

package com.employee.Employee.Management.System.Controller;

import com.employee.Employee.Management.System.CustomResponse.ApiResponsePagination;
import com.employee.Employee.Management.System.CustomResponse.ApiResponseSuccess;
import com.employee.Employee.Management.System.CustomResponse.PaginationInfo;
import com.employee.Employee.Management.System.Dto.EmployeeRequest;
import com.employee.Employee.Management.System.Entity.Employee;
import com.employee.Employee.Management.System.Exception.EmployeeNotFoundException;
import com.employee.Employee.Management.System.Service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/home")
    public String home(){
        return "Welcome to employee management system";
    }

    @PostMapping("/api/create-employee")
    public ResponseEntity<ApiResponseSuccess<Map<String, Object>>> createEmployee(@RequestBody @Valid EmployeeRequest employeeRequest){
        Employee createdEmployee=employeeService.createNewEmployee(employeeRequest);
        ApiResponseSuccess<Map<String, Object>> response = new ApiResponseSuccess<>(new HashMap<>(), true, HttpStatus.CREATED.value(),"Employee created successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
//        return ResponseEntity.status(HttpStatus.CREATED).body(createdEmployee);
    }

    @GetMapping("/api/all-employees")
    public ResponseEntity<ApiResponsePagination<List<Employee>>> getEmployees( @RequestParam(defaultValue = "1") int page,
        @RequestParam(defaultValue = "10") int limit){
//        List<Employee> allEmployees = employeeService.getAllEmployees();
        Page<Employee> allEmployees = employeeService.getAllEmployees(page, limit);
        PaginationInfo paginationInfo = new PaginationInfo(
                page ,  // Adjusting page number for user-friendly display
                allEmployees.getTotalPages(),
                allEmployees.getTotalElements()
        );
        ApiResponsePagination<List<Employee>> response = new ApiResponsePagination<>(allEmployees.getContent(), true, HttpStatus.OK.value(),"Employee getting from DB successfully",paginationInfo);
        return new ResponseEntity<>(response, HttpStatus.OK);
//        return ResponseEntity.status(HttpStatus.OK).body(allEmployees);
//        List<Employee> allEmployees = employeeService.getAllEmployees();
//        ApiResponseSuccess<List<Employee>> response = new ApiResponseSuccess<>(allEmployees, true, HttpStatus.OK.value(), "Employee getting from DB successfully");
//        return new ResponseEntity<>(response, HttpStatus.OK);
//        return ResponseEntity.status(HttpStatus.OK).body(allEmployees);

    }

    @PutMapping("/api/edit-employee")
    public ResponseEntity<ApiResponseSuccess<Map<String, Object>>> updateEmployee(@RequestBody @Valid EmployeeRequest employeeRequest) throws EmployeeNotFoundException {
        Employee updatedEmployee=employeeService.editEmployee(employeeRequest);
        ApiResponseSuccess<Map<String, Object>> response = new ApiResponseSuccess<>(new HashMap<>(), true, HttpStatus.OK.value(),"Employee updated successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
//        return ResponseEntity.status(HttpStatus.OK).body(updatedEmployee);
    }

    @DeleteMapping("/api/delete-employee")
    public ResponseEntity<ApiResponseSuccess<Map<String, Object>>> deleteEmployee(@RequestParam long employeeId) throws EmployeeNotFoundException {
        employeeService.removeEmployee(employeeId);
        ApiResponseSuccess<Map<String, Object>> response = new ApiResponseSuccess<>(new HashMap<>(), true, HttpStatus.OK.value(),"Employee deleted successfully");
        return new ResponseEntity<>(response, HttpStatus.OK);
//        return ResponseEntity.status(HttpStatus.OK).body("Employee deleted successfully");
    }
}

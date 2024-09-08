package com.employee.Employee.Management.System.Controller;

import com.employee.Employee.Management.System.CustomResponse.ApiResponseSuccess;
import com.employee.Employee.Management.System.Dto.AdminRequest;
import com.employee.Employee.Management.System.Entity.Admin;
import com.employee.Employee.Management.System.Service.AdminService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class AdminController {
    @Autowired
    private AdminService adminService;

    @PostMapping("/admin/create-admin")
    public ResponseEntity<ApiResponseSuccess<Map<String, Object>>> createAdmin(@RequestBody @Valid AdminRequest adminRequest){
       Admin createdAdmin= adminService.createNewAdmin(adminRequest);
        ApiResponseSuccess<Map<String, Object>> response = new ApiResponseSuccess<>(new HashMap<>(), true, HttpStatus.CREATED.value(),"Admin created successfully");
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }
}

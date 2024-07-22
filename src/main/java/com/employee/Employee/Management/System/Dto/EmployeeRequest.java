package com.employee.Employee.Management.System.Dto;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class EmployeeRequest {

    private long employeeId;

    @NotEmpty(message = "Name is required field")
    @Pattern(regexp = "^[a-zA-Z\\s]{3,25}$",message = "Invalid name format")
    private String name;

    @NotEmpty(message = "Email is required field")
    @Email(message = "Invalid email address")
    private String email;

    @NotEmpty(message = "Phone No. is required field")
    @Pattern(regexp="^[6789]\\d{9}$",message = "Invalid phone number")
    private String phone;

    @NotEmpty(message = "Designation is required field")
    @Pattern(regexp = "^[a-zA-Z\\s]{3,35}$",message = "Invalid designation format")
    private String designation;

    @NotEmpty(message = "Department is required field")
    @Pattern(regexp = "^[a-zA-Z\\s]{2,25}$",message = "Invalid department format")
    private String department;

    @NotEmpty(message = "Salary is required field")
    @Pattern(regexp = "^[0-9]{4,15}$",message = "Invalid salary format")
    private String salary;

    @NotEmpty(message = "Date of joining is required field")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$",message = "Date of joining must be in the format yyyy-mmgit-dd")
    private String date_of_joining;
//    private String password="Admin@123";
}

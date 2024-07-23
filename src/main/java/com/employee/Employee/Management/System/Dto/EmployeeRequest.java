package com.employee.Employee.Management.System.Dto;

import com.employee.Employee.Management.System.CustomValidation.ValidateDateOfJoining;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.Date;

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
    @Min(value = 1000,message = "Salary should not be less than 1000")
    private String salary;

    @NotEmpty(message = "Date of joining is required field")
    @Pattern(regexp = "^\\d{4}-\\d{2}-\\d{2}$",message = "Date of joining must be in the format yyyy-mm-dd")
    @ValidateDateOfJoining(message = "Date of joining should not be in future")
    private String date_of_joining;
//    private String password="Admin@123";
}

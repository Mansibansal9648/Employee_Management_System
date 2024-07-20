package com.employee.Employee.Management.System.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
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
    private String name;
    @Email(message = "Invalid email")
    @NotEmpty(message = "Email is required field")
    private String email;
    @NotNull(message = "Phone No. is required field")
//    @Pattern(regexp="")
    private long phone;
    @NotEmpty(message = "Designation is required field")
    private String designation;
    @NotEmpty(message = "Department is required field")
    private String department;

    @NotNull(message = "Salary is required field")
    private int salary;
    @NotNull(message = "Date of joining is required field")
    private LocalDate date_of_joining;
//    private String password="Admin@123";
}

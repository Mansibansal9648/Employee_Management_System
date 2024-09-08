package com.employee.Employee.Management.System.Dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AdminRequest {

    @NotEmpty(message = "Name is required field")
    @Pattern(regexp = "^[a-zA-Z\\s]{3,25}$",message = "Invalid name format")
    private String name;

    @NotEmpty(message = "Email is required field")
    @Email(message = "Invalid email address")
    private String email;

    @NotEmpty(message = "User type is required field")
    private String userType;

    @NotEmpty(message = "Password is required field")
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{6,30}$", message = "Password must contain at least one lowercase letter, one uppercase letter, one number, one special character and be at least 6 characters long")
    private String password;

}

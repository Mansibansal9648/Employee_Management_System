package com.employee.Employee.Management.System.CustomValidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UserTypeValidator implements ConstraintValidator<ValidateUserType,String> {
    private static final String ADMIN="Admin";
    private static final String EMPLOYEE="Employee";
    @Override
    public boolean isValid(String userType, ConstraintValidatorContext constraintValidatorContext) {
        if (userType == null || userType.isEmpty()) {
            return false;
        }
        return isValidAdmin(userType) || isValidEmployee(userType);
    }

    private boolean isValidAdmin(String userType) {
        return ADMIN.equals(userType);
    }

    private boolean isValidEmployee(String userType) {
        return EMPLOYEE.equals(userType);
    }
}


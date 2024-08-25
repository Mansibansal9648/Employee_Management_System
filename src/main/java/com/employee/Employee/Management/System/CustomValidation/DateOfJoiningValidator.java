package com.employee.Employee.Management.System.CustomValidation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class DateOfJoiningValidator implements ConstraintValidator<ValidateDateOfJoining,String> {

    private DateTimeFormatter dateFormatter;

    @Override
    public void initialize(ValidateDateOfJoining validateDateOfJoining) {
        this.dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    }

    @Override
    public boolean isValid(String dateOfJoining , ConstraintValidatorContext constraintValidatorContext) {
        if (dateOfJoining == null || !dateOfJoining.matches("^\\d{4}-\\d{2}-\\d{2}$")) {
            return true; // Skip validation if the pattern doesn't match
        }
        LocalDate doj = LocalDate.parse(dateOfJoining, dateFormatter);
        LocalDate currentDate = LocalDate.now();
//      if(doj>currentDate){
//          return false;
//      }
//      return true;
        return !doj.isAfter(currentDate);
    }
}

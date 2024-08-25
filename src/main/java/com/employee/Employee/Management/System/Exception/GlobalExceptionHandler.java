package com.employee.Employee.Management.System.Exception;

import com.employee.Employee.Management.System.CustomResponse.ApiResponseError;
import com.employee.Employee.Management.System.CustomResponse.ApiResponseSuccess;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.context.support.DefaultMessageSourceResolvable;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiResponseError<Map<String,Object>>> handleInvalidArgument(MethodArgumentNotValidException ex){
//        Map<String,String> errorMap=new HashMap<>();
//        ex.getBindingResult().getFieldErrors().forEach(error->{
//            errorMap.put(error.getField(),error.getDefaultMessage());
//        });
        List<String> errors = ex.getBindingResult()
                .getFieldErrors()
                .stream()
                .map(DefaultMessageSourceResolvable::getDefaultMessage)
                .collect(Collectors.toList());

        String firstError = errors.isEmpty() ? "Validation error" : errors.get(0);
        String allErrors = String.join(", ", errors);
        ApiResponseError<Map<String, Object>> response = new ApiResponseError<>(null, false, HttpStatus.BAD_REQUEST.value(),firstError,allErrors);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
    }

    @ExceptionHandler(EmployeeNotFoundException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiResponseError<Map<String,Object>>> handleNotFoundException(EmployeeNotFoundException ex){
//        Map<String,String> errorMap=new HashMap<>();
//        errorMap.put("errMessage", ex.getMessage());
        ApiResponseError<Map<String, Object>> response = new ApiResponseError<>(null, false, HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
    }

    @ExceptionHandler(IllegalArgumentException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<ApiResponseError<Map<String,Object>>> handleIllegalArgument(IllegalArgumentException ex){
//        Map<String,String> errorMap=new HashMap<>();
//        errorMap.put("errMessage", ex.getMessage());
        ApiResponseError<Map<String, Object>> response = new ApiResponseError<>(null, false, HttpStatus.BAD_REQUEST.value(), ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
//        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorMap);
    }
}

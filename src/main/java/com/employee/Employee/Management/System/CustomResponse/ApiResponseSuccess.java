package com.employee.Employee.Management.System.CustomResponse;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiResponseSuccess<T> {
    private T data;
    private boolean isSuccess;
    private int statusCode;
    private String resMessage;
}

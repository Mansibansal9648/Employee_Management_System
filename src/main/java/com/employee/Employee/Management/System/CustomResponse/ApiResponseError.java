package com.employee.Employee.Management.System.CustomResponse;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiResponseError<T> {
    private T data;
    private boolean isSuccess;
    private int statusCode;
    private String errMessage = "Something went wrong";
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String additionalErr;

    public ApiResponseError(T data, boolean isSuccess, int statusCode, String errMessage){

        this.data = data;
        this.isSuccess = isSuccess;
        this.errMessage = errMessage;
        this.statusCode = statusCode;
//        this.additionalErr = null; // Default to null
    }
}

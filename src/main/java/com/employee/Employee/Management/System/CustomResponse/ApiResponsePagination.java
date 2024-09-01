package com.employee.Employee.Management.System.CustomResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ApiResponsePagination<T> {
    private T data;
    private boolean success;
    private int responseCode;
    private String resMessage;
    private PaginationInfo pagination;
}

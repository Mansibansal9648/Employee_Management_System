package com.employee.Employee.Management.System.CustomResponse;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaginationInfo {
    private int page;
    private int totalPages;
    private long totalItems;
}

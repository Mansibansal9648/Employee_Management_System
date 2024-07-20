package com.employee.Employee.Management.System.Service;

import com.employee.Employee.Management.System.Dto.EmployeeRequest;
import com.employee.Employee.Management.System.Entity.Employee;

import java.util.List;

public interface EmployeeService {
    public Employee createNewEmployee(EmployeeRequest employeeRequest);
    public List<Employee> getAllEmployees();
}

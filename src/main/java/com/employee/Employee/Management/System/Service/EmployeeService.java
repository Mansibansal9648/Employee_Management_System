package com.employee.Employee.Management.System.Service;

import com.employee.Employee.Management.System.Dto.EmployeeRequest;
import com.employee.Employee.Management.System.Entity.Employee;
import com.employee.Employee.Management.System.Exception.EmployeeNotFoundException;

import java.util.List;

public interface EmployeeService {
    public Employee createNewEmployee(EmployeeRequest employeeRequest);
    public List<Employee> getAllEmployees();

    public Employee editEmployee(EmployeeRequest employeeRequest) throws EmployeeNotFoundException;
}

package com.employee.Employee.Management.System.Service;

import com.employee.Employee.Management.System.Dto.EmployeeRequest;
import com.employee.Employee.Management.System.Entity.Employee;
import com.employee.Employee.Management.System.Exception.EmployeeNotFoundException;
import org.springframework.data.domain.Page;

import java.util.List;

public interface EmployeeService {
    public Employee createNewEmployee(EmployeeRequest employeeRequest);
    public Page<Employee> getAllEmployees(int page,int limit);
    public Employee editEmployee(EmployeeRequest employeeRequest) throws EmployeeNotFoundException;
    public void removeEmployee(long employeeId) throws EmployeeNotFoundException;
}

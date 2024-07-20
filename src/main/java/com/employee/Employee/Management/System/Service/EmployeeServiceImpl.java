package com.employee.Employee.Management.System.Service;

import com.employee.Employee.Management.System.Dao.EmployeeDao;
import com.employee.Employee.Management.System.Dto.EmployeeRequest;
import com.employee.Employee.Management.System.Entity.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;
    @Override
    public Employee createNewEmployee(EmployeeRequest employeeRequest) {
        Employee employee=new Employee(employeeRequest);
        return employeeDao.save(employee);
    }
}

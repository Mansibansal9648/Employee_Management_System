package com.employee.Employee.Management.System.Service;

import com.employee.Employee.Management.System.Dao.EmployeeDao;
import com.employee.Employee.Management.System.Dto.EmployeeRequest;
import com.employee.Employee.Management.System.Entity.Employee;
import com.employee.Employee.Management.System.Exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeDao employeeDao;
    @Override
    public Employee createNewEmployee(EmployeeRequest employeeRequest) {
        Employee employee=new Employee();
        employee.setName(employeeRequest.getName());
        employee.setEmail(employeeRequest.getEmail());
        employee.setPhone(employeeRequest.getPhone());
        employee.setDesignation(employeeRequest.getDesignation());
        employee.setDepartment(employeeRequest.getDepartment());
        employee.setSalary(employeeRequest.getSalary());
        employee.setDate_of_joining(employeeRequest.getDate_of_joining());
        return employeeDao.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return employeeDao.findAll();
    }

    @Override
    public Employee editEmployee(EmployeeRequest employeeRequest) throws EmployeeNotFoundException {
        long id=employeeRequest.getEmployeeId();
        Employee existingEmployee=employeeDao.findById(id)
                .orElseThrow(()->new EmployeeNotFoundException("Employee doesn't exist"));
        existingEmployee.setName(employeeRequest.getName());
        existingEmployee.setEmail(employeeRequest.getEmail());
        existingEmployee.setPhone(employeeRequest.getPhone());
        existingEmployee.setDesignation(employeeRequest.getDesignation());
        existingEmployee.setDepartment(employeeRequest.getDepartment());
        existingEmployee.setSalary(employeeRequest.getSalary());
        existingEmployee.setDate_of_joining(employeeRequest.getDate_of_joining());
        return employeeDao.save(existingEmployee);
    }

    public void removeEmployee(long employeeId) throws EmployeeNotFoundException {
        Employee existingEmployee=employeeDao.findById(employeeId)
                .orElseThrow(()->new EmployeeNotFoundException("Employee doesn't exist"));
        employeeDao.delete(existingEmployee);
    }
}

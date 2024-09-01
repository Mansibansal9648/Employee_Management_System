package com.employee.Employee.Management.System.Service;

import com.employee.Employee.Management.System.Dao.EmployeeDao;
import com.employee.Employee.Management.System.Dto.EmployeeRequest;
import com.employee.Employee.Management.System.Entity.Employee;
import com.employee.Employee.Management.System.Exception.EmployeeNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import org.springframework.data.domain.Pageable;
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

        boolean isEmail= employeeDao.existsByEmail(employee.getEmail());
        boolean isPhone=employeeDao.existsByPhone(employee.getPhone());

        if(isEmail && isPhone){
            throw new IllegalArgumentException("Email and Phone no already exists");
        }

        if(isEmail){
            throw new IllegalArgumentException("Email already exists");
        }

        if(isPhone){
            throw new IllegalArgumentException("Phone no already exists");
        }

        return employeeDao.save(employee);
    }

    @Override
    public Page<Employee> getAllEmployees(int page, int limit) {
        page=page-1;
        Pageable pageable= PageRequest.of(page, limit, Sort.by("id").ascending());

        return employeeDao.findAll(pageable);
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

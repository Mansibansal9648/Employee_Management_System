package com.employee.Employee.Management.System.Dao;

import com.employee.Employee.Management.System.Entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeDao extends JpaRepository<Employee,Long> {

    boolean existsByEmail(String email);
    boolean existsByPhone(String phone);
}

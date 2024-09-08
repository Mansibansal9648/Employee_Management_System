package com.employee.Employee.Management.System.Dao;

import com.employee.Employee.Management.System.Entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminDao extends JpaRepository<Admin,Long> {

    boolean existsByEmail(String email);
}

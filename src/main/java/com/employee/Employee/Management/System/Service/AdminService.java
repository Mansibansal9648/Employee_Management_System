package com.employee.Employee.Management.System.Service;

import com.employee.Employee.Management.System.Dto.AdminRequest;
import com.employee.Employee.Management.System.Entity.Admin;


public interface AdminService {

    public Admin createNewAdmin(AdminRequest adminRequest);
}

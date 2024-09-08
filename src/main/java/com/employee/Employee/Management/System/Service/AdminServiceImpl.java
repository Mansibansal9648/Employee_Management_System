package com.employee.Employee.Management.System.Service;

import com.employee.Employee.Management.System.Dao.AdminDao;
import com.employee.Employee.Management.System.Dto.AdminRequest;
import com.employee.Employee.Management.System.Entity.Admin;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminServiceImpl implements AdminService{
    @Autowired
    private AdminDao adminDao;
    @Override
    public Admin createNewAdmin(AdminRequest adminRequest) {
        Admin admin=new Admin();
        admin.setName(adminRequest.getName());
        admin.setEmail(adminRequest.getEmail());
        admin.setUserType(adminRequest.getUserType());
        admin.setPassword(adminRequest.getPassword());

        boolean isEmail= adminDao.existsByEmail(admin.getEmail());

        if(isEmail){
            throw new IllegalArgumentException("Email already exists");
        }
        return adminDao.save(admin);
    }
}

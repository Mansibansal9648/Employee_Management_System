package com.employee.Employee.Management.System.Entity;

import com.employee.Employee.Management.System.Dto.EmployeeRequest;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
//    @Column(unique = true)
    private String email;
//    @Column(unique = true)
    private long phone;
    private String designation;
    private String department;

    private int salary;
    private LocalDate date_of_joining;
    private String password="Admin@123";

    public Employee(EmployeeRequest employeeRequest){
        this.name=employeeRequest.getName();
        this.email=employeeRequest.getEmail();
        this.phone=employeeRequest.getPhone();
        this.designation=employeeRequest.getDesignation();
        this.department=employeeRequest.getDepartment();
        this.salary=employeeRequest.getSalary();
        this.date_of_joining=employeeRequest.getDate_of_joining();
    }

}

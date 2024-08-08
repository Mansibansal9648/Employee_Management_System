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
    private String phone;
    private String designation;
    private String department;

    private String salary;
    private String date_of_joining;
    private String password="Admin@123";

}

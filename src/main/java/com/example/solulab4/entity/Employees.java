package com.example.solulab4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@Entity
@Table(name = "employees")
public class Employees {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "employee_id", nullable=false)
    private Integer id;

    @Column(name = "first_name", nullable = false, length = 20)
    private String first_name;

    @Column(name = "last_name", nullable = false, length = 25)
    private String last_name;

    @Column(name = "email", nullable = false, length = 25)
    private String email;

    @Column(name = "password",  length = 65)
    private String password;

    @Column(name = "phone_number",  length = 25)
    private String phone_number;

    @Column(name = "hire_date", nullable = false)
    private LocalDate hire_date;

    @ManyToOne
    @JoinColumn(name = "job_id", nullable = false)
    private Jobs job;

    @Column(name = "salary")
    private Double salary;

    @Column(name = "commission_pct")
    private Double commission_pct;

    @ManyToOne
    @JoinColumn(name = "manager_id")
    private Employees manager;


    @ManyToOne
    @JoinColumn(name = "department_id")
    private Departments department;

    @Column(name = "enabled")
    private Integer enabled;


}

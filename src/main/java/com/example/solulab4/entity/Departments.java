package com.example.solulab4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "departments")
public class Departments {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "department_id", nullable=false)
    private Integer id;

    @Column(name = "department_name", nullable = false, length = 20)
    private String departmentname;

    @ManyToOne
    @JoinColumn(name = "location_id", nullable = false)
    private Locations location;
}

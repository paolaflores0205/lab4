package com.example.solulab4.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "jobs")
public class Jobs {
    @Id
    @Column(name = "job_id", nullable=false, length = 10)
    private String id;

    @Column(name = "job_title", nullable = false, length = 35)
    private String jobtitle;

    


}

package com.example.solulab4.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "locations")
public class Locations {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "location_id", nullable=false)
    private Integer id;

    @Column(name = "city", nullable = false, length = 30)
    private String city;
}

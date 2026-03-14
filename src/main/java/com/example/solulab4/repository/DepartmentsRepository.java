package com.example.solulab4.repository;
import com.example.solulab4.entity.Departments;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface DepartmentsRepository extends JpaRepository<Departments,Integer>{
}

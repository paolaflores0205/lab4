package com.example.solulab4.repository;
import com.example.solulab4.entity.Jobs;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
public interface JobsRepository extends JpaRepository<Jobs,Integer>{
}

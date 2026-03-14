package com.example.solulab4.repository;
import com.example.solulab4.entity.Locations;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import javax.xml.stream.Location;

public interface LocationsRepository extends JpaRepository<Locations,Integer>{

}

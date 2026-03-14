package com.example.solulab4.repository;
import com.example.solulab4.entity.Employees;
import com.example.solulab4.entity.Jobs;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface EmployeesRepository extends JpaRepository<Employees,Integer>{
    @Query(value = "select * from employees e " +
            "left join jobs j on e.job_id = j.job_id  " +
            "left join departments d on e.department_id = d.department_id " +
            "left join locations l on l.location_id =d.location_id " +
            "where e.first_name like %?1% " +
            "or e.last_name like %?1% " +
            "or j.job_title like %?1% " +
            "or l.city like %?1% ", nativeQuery = true)
    List<Employees> listaFiltros(String buscar);

    @Transactional
    @Modifying
    @Query(nativeQuery = true,
        value = "update employees set department_id = ?1, job_id=?2 " +
                "where employee_id=?3")
    void actualizarEmployee(Integer depId, Integer jobId,  Integer employeeId);




}

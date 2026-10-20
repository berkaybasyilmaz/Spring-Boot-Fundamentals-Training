package com.trainingspring.springormtraining.relation;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface EmployeeRepository extends CrudRepository<Employee, UUID> {

    @Query("""
      select e from Employee e where e.department.departmentId == :departmentId
           """)
    List<Employee> findByDepartment(@Param("departmentId") UUID departmentId);


}

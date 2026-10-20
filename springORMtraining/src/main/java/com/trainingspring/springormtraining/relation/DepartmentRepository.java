package com.trainingspring.springormtraining.relation;

import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;

public interface DepartmentRepository  extends CrudRepository<Department, UUID> {
    Optional<Department> findById(UUID uuid);
}

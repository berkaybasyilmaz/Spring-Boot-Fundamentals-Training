package com.trainingspring.springormtraining.relation;

import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/json")
public class JsonController {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public JsonController(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
        this.employeeRepository = employeeRepository;
    }

    @GetMapping("/employee/{id}")
    public Department findDepartmentById(@PathVariable("id") String departmentId) {

        Optional<Department> departmentOptional = departmentRepository.findById(UUID.fromString(departmentId));

        if(departmentOptional.isPresent()) {
            return departmentOptional.get();
        } else {
            throw new RuntimeException("Department not found with id: " + departmentId);
        }
    }


}

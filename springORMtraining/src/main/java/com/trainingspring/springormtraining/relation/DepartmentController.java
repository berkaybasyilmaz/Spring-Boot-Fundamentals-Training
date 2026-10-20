package com.trainingspring.springormtraining.relation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.Optional;
import java.util.UUID;

@RestController
@RequestMapping("/department")
public class DepartmentController {

    private final DepartmentRepository departmentRepository;

    public DepartmentController(DepartmentRepository departmentRepository) {
        this.departmentRepository = departmentRepository;
    }

    @GetMapping("/generate")
     public String generateDepartment() {
        Department department = new Department() ;
        department.setDepartmentId(UUID.randomUUID());
        department.setDepartmentName("IT");

        for(int i=0; i<3; i++) {
            Employee employee = new Employee();
            employee.setEmployeeId(UUID.randomUUID());
            employee.setEmployeeName("Employee " + (i+1));
            employee.setMonthlySalary(5000 + (i * 1000));
            employee.setDepartment(department);// Set the department for the employee
            department.setEmployees(new ArrayList<>());
        }

        departmentRepository.save(department);

        return "Department generated with employe es" + department.getDepartmentId() + "" + department.getDepartmentName();
     }

     @GetMapping("/find/{depid}")
     public String findDepartmentById(@PathVariable("depid") String departmentId) {

         Optional<Department> departmentOptional = departmentRepository.findById(UUID.fromString(departmentId));
         if(departmentOptional.isEmpty()){
             throw new RuntimeException("Department not found with id: " + departmentId);
         }

         Department department = departmentOptional.get();

         // employee listesini rahatça alabiliyoruz bu şekilde
         for(Employee employee : department.getEmployees()){

             System.out.println(employee.getEmployeeName());

         }

         return "Departman" + department.getDepartmentId() + " " + department.getDepartmentName();

     }

}

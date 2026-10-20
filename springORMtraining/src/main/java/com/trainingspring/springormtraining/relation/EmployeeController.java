package com.trainingspring.springormtraining.relation;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.UUID;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeRepository employeeRepository;
    private final DepartmentRepository departmentRepository;

    public EmployeeController(EmployeeRepository employeeRepository, DepartmentRepository departmentRepository) {
        this.employeeRepository = employeeRepository;
        this.departmentRepository = departmentRepository;
    }

    @GetMapping("/generate/{depid}")
    public String generateEmployee(@PathVariable("depid") String departmentId){

        Optional<Department> departmentOptional = departmentRepository.findById(UUID.fromString(departmentId));
        if(departmentOptional.isEmpty()){
            throw new RuntimeException("Department not found with id: " + departmentId);
        }

        Department department = departmentOptional.get();

            Employee employee = new Employee();
            employee.setEmployeeId(UUID.randomUUID());
            employee.setEmployeeName("Çalışan A" );
            employee.setMonthlySalary(8000  * 15500);
            employee.setDepartment(department);


        employeeRepository.save(employee);

        return "employee generated with id: " + employee.getEmployeeId() + " for department: " + department.getDepartmentName();

    }

    @GetMapping("/find/{employeeId}")
    public String getEmployeeById(@PathVariable("employeeId") String employeeId) {
        Optional<Employee> employeeOptional = employeeRepository.findById(UUID.fromString(employeeId));
        if (employeeOptional.isEmpty()) {
            throw new RuntimeException("Department not found with id: " + employeeId);
        }

        Employee employee = employeeOptional.get();
        return "Employee found with id: " + employee.getEmployeeId() + " and name: "
                + employee.getEmployeeName() +
                " in department: " + employee.getDepartment().getDepartmentName(); // JPA sayesinde departmanın id sine kadar getiriyor
    }

    @GetMapping("/list-by-departmentid/{depid}")
    public String getEmployeesByDepartment(@PathVariable("depid") String departmentId){
        StringBuilder builder = new StringBuilder();
        for(var employee : employeeRepository.findByDepartment(UUID.fromString(departmentId))){
            builder.append(employee.getEmployeeName()).append("<br/>");
        }
        return builder.toString();
    }


}

package com.trainingspring.springormtraining.relation;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;

import java.util.List;
import java.util.UUID;

@Entity
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID departmentId;
    private String departmentName;

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @JsonBackReference // BUNU ATLA JSON A ÇEVİRME
    @OneToMany(mappedBy = "department", cascade = CascadeType.ALL) // cascade all : burda yapılan orayıda etkilesin.
    // Yani departmanı silince employee lerde silinsin gibi.
    private List<Employee> employees;

    public Department(UUID departmentId, String departmentName) {
        this.departmentId = departmentId;
        this.departmentName = departmentName;
    }

    public Department() {

    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void setDepartmentName(String departmentName) {
        this.departmentName = departmentName;
    }

    public UUID getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(UUID departmentId) {
        this.departmentId = departmentId;
    }




}

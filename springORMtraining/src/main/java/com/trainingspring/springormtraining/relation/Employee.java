package com.trainingspring.springormtraining.relation;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Employee {

    @Id
    private UUID employeeId;
    private String employeeName;
    private double monthlySalary;

    public Department getDepartment() {
        return department;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    @JsonManagedReference // JSON A ÇEVİR.
    // Olduğun class ı baz alarak ilişkiyi kurarız. Foreign key bağlantısı yaparız.
    @ManyToOne
    @JoinColumn(name = "department_id") // bu isimde column olarak ekle
    private Department department;

    public Employee(UUID employeeId, String employeeName, double monthlySalary) {
        this.employeeId = employeeId;
        this.employeeName = employeeName;
        this.monthlySalary = monthlySalary;
    }
    public Employee() {
    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(UUID employeeId) {
        this.employeeId = employeeId;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public double getMonthlySalary() {
        return monthlySalary;
    }

    public void setMonthlySalary(double monthlySalary) {
        this.monthlySalary = monthlySalary;
    }









}

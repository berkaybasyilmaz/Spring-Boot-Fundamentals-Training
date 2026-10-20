package com.trainingspring.springormtraining.Query;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Supplier {
    public Supplier(UUID supplierId, String supplierName, double totalDebit) {
        this.supplierId = supplierId;
        this.supplierName = supplierName;
        this.totalDebit = totalDebit;
    }
    public Supplier() {

    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID supplierId;
    private String supplierName;
    private double totalDebit;

    public UUID getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(UUID supplierId) {
        this.supplierId = supplierId;
    }

    public String getSupplierName() {
        return supplierName;
    }

    public void setSupplierName(String supplierName) {
        this.supplierName = supplierName;
    }

    public double getTotalDebit() {
        return totalDebit;
    }

    public void setTotalDebit(double totalDebit) {
        this.totalDebit = totalDebit;
    }
}

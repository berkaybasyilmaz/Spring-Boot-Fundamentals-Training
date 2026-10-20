package com.trainingspring.application.receivables.data;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Customer {

    @Id
    private UUID customerId;
    private String customerName;
    private  double totalDebit;

    public Customer(UUID customerId, String customerName, double totalDebit) {
        this.customerId = customerId;
        this.customerName = customerName;
        this.totalDebit = totalDebit;
    }

    public Customer() {

    }

    public UUID getCustomerId() {
        return customerId;
    }

    public void setCustomerId(UUID customerId) {
        this.customerId = customerId;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public double getTotalDebit() {
        return totalDebit;
    }

    public void setTotalDebit(double totalDebit) {
        this.totalDebit = totalDebit;
    }




}

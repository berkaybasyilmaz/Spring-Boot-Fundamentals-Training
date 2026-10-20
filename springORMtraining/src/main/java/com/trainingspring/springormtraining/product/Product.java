package com.trainingspring.springormtraining.product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private UUID Productid;
    private String ProductName;
    private double SalesPrice;

    public Product(UUID Productid, String productName, double salesPrice) {
        this.Productid = Productid;
        this.ProductName = productName;
        this.SalesPrice = salesPrice;
    }
    public Product() {

    }
    public UUID getProductid() {
        return Productid;
    }



}

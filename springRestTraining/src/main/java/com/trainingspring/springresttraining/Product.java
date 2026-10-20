package com.trainingspring.springresttraining;

import org.springframework.stereotype.Component;

public class Product {

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private long id;

    public Product(long id, String name, double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
    public Product() {

    }

    private String name;
    private double price;

}



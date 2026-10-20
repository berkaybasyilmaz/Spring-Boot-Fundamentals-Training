package com.trainingspring.springresttraining.Client;

import com.trainingspring.springresttraining.Product;
import org.springframework.web.client.RestTemplate;

// post - restTemplate ( spesifik adresle işlemler)  işlemi için example classı
public class PutClient {
    public static void main(String[] args) {

        String uri = "http://localhost:8080/product";
        RestTemplate restTemplate = new RestTemplate();

        Product product = new Product(304, "Laptop Computer" , 12131231);

        restTemplate.put(uri, product, Void.class);

    }
}

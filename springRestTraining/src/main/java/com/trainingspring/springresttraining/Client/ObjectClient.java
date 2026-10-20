package com.trainingspring.springresttraining.Client;

import com.trainingspring.springresttraining.Product;
import org.springframework.web.client.RestTemplate;

public class ObjectClient {
    public static void main(String[] args) {
        String uri = "http://localhost:8080/product";

        // RestTemplate le belirlinen url ye gidip, getForObject le de birlikte get isteği atabiliyoruz.
        RestTemplate restTemplate = new RestTemplate();

        Product product = restTemplate.getForObject(uri, Product.class);
        System.out.println("product "+ product.getId()+ product.getName()+ product.getPrice());
    }
}

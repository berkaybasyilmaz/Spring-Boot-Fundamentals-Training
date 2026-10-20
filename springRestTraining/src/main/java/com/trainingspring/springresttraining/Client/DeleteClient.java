package com.trainingspring.springresttraining.Client;

import org.springframework.web.client.RestTemplate;

public class DeleteClient {
    public static void main(String[] args) {
        long id = 305;
        String uri = "http://localhost:8080/product" + id;
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.delete(uri);
    }
}

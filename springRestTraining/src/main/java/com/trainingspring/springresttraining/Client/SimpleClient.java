package com.trainingspring.springresttraining.Client;

import org.springframework.web.client.RestTemplate;

public class SimpleClient {
    public static void main(String[] args) {
        String uri = "http://localhost:8080/product/count";
        RestTemplate restTemplate = new RestTemplate();

        Integer count = restTemplate.getForObject(uri, Integer.class);
        System.out.println(count);
    }
}

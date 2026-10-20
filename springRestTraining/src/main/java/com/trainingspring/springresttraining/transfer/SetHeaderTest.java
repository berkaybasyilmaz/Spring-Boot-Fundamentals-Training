package com.trainingspring.springresttraining.transfer;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SetHeaderTest { // isteğin bizi hatırlaması için (state)
    public static void main(String[] args) {


        String uri = "http://localhost:8080/transfer/setheader/";
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, String.class);

        String result = response.getBody();

        System.out.println("Result : " + result);

        String input = response.getHeaders().getFirst("input");

        System.out.println("input : " + input);

    }


}

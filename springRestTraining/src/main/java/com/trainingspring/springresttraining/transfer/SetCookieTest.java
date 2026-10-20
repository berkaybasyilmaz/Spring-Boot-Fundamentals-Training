package com.trainingspring.springresttraining.transfer;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class SetCookieTest {
    public static void main(String[] args) {


        String uri = "http://localhost:8080/transfer/setcookie/";
        RestTemplate restTemplate = new RestTemplate();

        //exchange( Nereye, Nasıl, Ne Gönderiyorum, Ne Bekliyorum )
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, HttpEntity.EMPTY, String.class);

        String result = response.getBody();

        System.out.println("Result : " + result);

        String cookie = response.getHeaders().getFirst(HttpHeaders.SET_COOKIE);

        System.out.println("input : " + cookie);

    }


}

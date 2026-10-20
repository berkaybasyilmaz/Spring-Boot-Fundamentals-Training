package com.trainingspring.springresttraining.receiving;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class GetHeaderTest {
    public static void main(String[] args) {
        String uri = "http://localhost:8080/transfer/setheader";
        RestTemplate restTemplate = new RestTemplate();

        HttpHeaders headers = new HttpHeaders();
        headers.add("input", "Godoro");

        HttpEntity<String> request = new HttpEntity<>("Gövde", headers);

        // Http.GET le yolladık cünkü DB ye yazmak yerine geçici gönderim yapıyoruz, kalırı oluşturmak istrsek Pull yapardık.
        ResponseEntity<String> response = restTemplate.exchange(uri, HttpMethod.GET, request, String.class);

        String result = response.getBody();

        System.out.println("Result : " + result);


    }

}

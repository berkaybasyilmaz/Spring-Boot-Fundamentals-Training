package com.trainingspring.springresttraining.Client;

import com.trainingspring.springresttraining.Product;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

// post - restTemplate ( spesifik adresle işlemler)  işlemi için example classı // postman vb. gibi uygulamalarla yapılan
// işlemlerin kod versiyonu gibi.
public class PostClient {
    public static void main(String[] args) {

        String uri = "http://localhost:8080/product";
        RestTemplate restTemplate = new RestTemplate();

        Product product = new Product(303, "Desktop Computer" , 12131231);

        // Long id = restTemplate.postForObject(uri, product, Long.class);

        //Exchange yapısı, üstteki işlemin çok daha katmanlı versiyonu ( ekstra güvenlik)
        ResponseEntity<Long> entity = restTemplate.exchange(uri, HttpMethod.POST,
                new HttpEntity<>(product), Long.class);
        long id = entity.getBody(); // id yi al
        System.out.println(id);
    }
}

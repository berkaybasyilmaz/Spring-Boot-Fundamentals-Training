package com.trainingspring.application.receivables.client;

import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class AddressClient {

    public AddressDto getAddress(String personId) {

        String url = "http://localhost:8082/location/address/" + personId;
        RestTemplate restTemplate = new RestTemplate();
        AddressDto addressDto = restTemplate.getForObject(url ,  AddressDto.class);
        return addressDto;

    }
}

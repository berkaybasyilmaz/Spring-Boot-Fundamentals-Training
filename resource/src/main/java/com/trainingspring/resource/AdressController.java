package com.trainingspring.resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/location")
// istek atma ve denemek için yaptık, normalde bu servisimizinde servis, repository , DB katmanları olmalı.
public class AdressController {

    @GetMapping("/address/{id}")
    public AddressDto getAddress(@PathVariable("id") String personId){
        AddressDto addressDto = new AddressDto();
        addressDto.setDistrictName("İstanbul");
        addressDto.setProvinceName("Çekmeköy");
        return addressDto;

    }

}

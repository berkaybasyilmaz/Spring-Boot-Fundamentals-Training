package com.trainingspring.springresttraining.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageController {

    // biri url sonuna hello derse EŞLEŞİCEK
    @GetMapping("/hello")
    public String getHello() {
        return "Hello!";
    }
    // üstteki getmapping anatasyonunun eski model kullanımı
    @RequestMapping(value = "/welcome", method = RequestMethod.GET)
    public String getWelcome(){
        return "Welcome!";
    }



}

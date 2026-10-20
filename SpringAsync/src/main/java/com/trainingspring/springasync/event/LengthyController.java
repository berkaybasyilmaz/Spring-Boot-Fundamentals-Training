package com.trainingspring.springasync.event;

import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LengthyController {

    private ApplicationEventPublisher eventPublisher;

    public LengthyController(ApplicationEventPublisher eventPublisher){
        this.eventPublisher = eventPublisher;
    }

    @GetMapping("/async/event/publish")
    public String publishAsync(){

        LengthyEvent event = new LengthyEvent(this, "Uzun");
        eventPublisher.publishEvent(event);
        System.out.printf("Uzun Event yayımlandı");
        return "Uzun event yayımlandı";
    }

}

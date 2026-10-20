package com.trainingspring.springevents.application;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class OperationController {

    private ApplicationEventPublisher publisher; // event i ortaya yayınlar, kim alıyor kim dinliyor umursamaz ve bilmez. EDA mantığı budur.

    public OperationController(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    // Event yollama işlemi
    @GetMapping("/event/operation")
    public String publishOperation(){
        var event = new OperationEvent(this, "Değerim");
        publisher.publishEvent(event);
        return "Operation published";
    }


}

package com.trainingspring.springevents.condition;

import com.trainingspring.springevents.application.OperationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConditionController {
    private ApplicationEventPublisher publisher;

    public ConditionController(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    @GetMapping("/event/condition/true")
    public String publishConditionTrue() {
        var event = new OperationEvent(this, "GODORO");
        publisher.publishEvent(event);
        return "Koşul doğru yayımlandı";
    }

    @GetMapping("/event/condition/false")
    public String publishConditionFalse() {
        var event = new OperationEvent(this, "FİBİLER");
        publisher.publishEvent(event);
        return "Koşul yanlış yayımlandı";
    }
}

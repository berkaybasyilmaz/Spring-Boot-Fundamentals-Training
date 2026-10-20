package com.trainingspring.springevents.annotation;

import com.trainingspring.springevents.application.OperationEvent;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class AnnotationListener {

    @EventListener // Spring e bunu dinle diye sesleniyoruz
    public void OperationPerformed(OperationEvent event) {
        System.out.println("Operation event received: " + event.getMyField());
    }

    @EventListener
    public void payloadReceived(PayloadApplicationEvent<String> event) {
        System.out.println("Payload event received: " + event.getPayload());

    }

}

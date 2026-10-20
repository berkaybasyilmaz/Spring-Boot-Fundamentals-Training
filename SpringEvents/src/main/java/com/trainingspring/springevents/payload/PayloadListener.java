package com.trainingspring.springevents.payload;

import com.trainingspring.springevents.application.OperationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.stereotype.Component;

@Component // dinliyor, bir olay olunca çalışacak
public class PayloadListener implements ApplicationListener<PayloadApplicationEvent<String>> {

    @Override
    public void onApplicationEvent(PayloadApplicationEvent<String> event) {
        System.out.println("Payload event received: " + event.getPayload());
    }
}




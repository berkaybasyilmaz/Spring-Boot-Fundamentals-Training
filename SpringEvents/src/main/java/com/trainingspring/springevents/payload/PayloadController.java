package com.trainingspring.springevents.payload;

import com.trainingspring.springevents.application.OperationEvent;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayloadController {

    private ApplicationEventPublisher publisher; // event i ortaya yayınlar, kim alıyor kim dinliyor umursamaz ve bilmez. EDA mantığı budur.

    public PayloadController(ApplicationEventPublisher publisher) {
        this.publisher = publisher;
    }

    // payload-event yollama işlemi
    @GetMapping("/event/payload")
    public String publishOperation(){
        var string = "Payload event data"; // benim nesnemi, payloadApplicationEvent e sarıp onunla yolluyor.
        publisher.publishEvent(string);
        return "payload published";
    }


}

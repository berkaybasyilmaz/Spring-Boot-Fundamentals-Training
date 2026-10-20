package com.trainingspring.springasync.event;

import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class LengthyListener {

    private void sleep(){
        try {
            Thread.sleep(10000);
        }
        catch (InterruptedException e) {
            System.out.printf(e.getMessage());
        }
    }

    @Async
    @EventListener // hem asenkron hem event yapısını bir arada kullanıyoruz.
    public void asynchronousCalled(LengthyEvent event) {
        sleep();

        System.out.printf("Asnenkron çağırıldı " + event.getMyField());
    }

}

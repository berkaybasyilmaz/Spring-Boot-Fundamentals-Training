package com.trainingspring.springasync.exception;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ExceptionPerformer {

    public void sleep(){
        try {
            Thread.sleep(5000); // 5 saniye bekle

        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Async
    public void doRisky(String id){
        sleep();
        throw new RuntimeException("Sorun var" + id);

    }

}

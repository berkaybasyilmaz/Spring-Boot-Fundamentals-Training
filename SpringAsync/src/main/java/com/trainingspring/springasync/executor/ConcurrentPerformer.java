package com.trainingspring.springasync.executor;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

@Component
public class ConcurrentPerformer {

    public void sleep(){
        try {
            Thread.sleep(5000); // 5 saniye bekle

        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }
    }

    @Async("threadPoolTaskExecutor")
    public void doExecutor(){
        sleep();
        System.out.println("Asenkron yapıldı.");

    }

}

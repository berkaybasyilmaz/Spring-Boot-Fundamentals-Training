package com.trainingspring.springasync.basics;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Component
public class MethodPerformer {

    public void sleep(){

        try {
            Thread.sleep(5000); // 5 saniye bekle
        }
        catch (InterruptedException e) {
            System.out.println(e.getMessage());
        }


    }

    @Async // sistem bunu arkada çalıştırır bir thred ( iplik ) açar, bizi rahatsız etmez.
    public void doSomething(){
        sleep();
        System.out.println("Asenkron ( eş zamansız ) yapıldı.");
    }

    @Async
    public Future<String> getSomething(){
        sleep();
        System.out.println("Senkron ( eş zamansız olmayan ) döndürüldü.");
        return CompletableFuture.completedFuture("Asenkron sonuç");
    }

}

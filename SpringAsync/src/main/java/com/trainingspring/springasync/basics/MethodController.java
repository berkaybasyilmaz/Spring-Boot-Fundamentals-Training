package com.trainingspring.springasync.basics;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.Future;

@RestController
public class MethodController {

    private final MethodPerformer methodPerformer;

    public MethodController(MethodPerformer methodPerformer) {
        this.methodPerformer = methodPerformer;
    }

    @GetMapping("/async/method/do-something")
    public String performDo(){
        methodPerformer.doSomething();
        return "Eş zamansız döndürüldü";
    }

    @GetMapping("/async/method/get-something")
    public String performGet(){
        try {
            // return "Eş zamansız sonuç" +  methodPerformer.getSomething().get();
            Future<String> future = methodPerformer.getSomething();
            while(true){
                if(future.isDone()){
                    return  "Dönüşlü yöntem sonucu"  +  future.get();
                }
                System.out.println("Sonuç bekleniyor...");
                Thread.sleep(1000); // 1 saniyede bir sonuç geldi mi diye soruyoruz
            }
        } catch (Exception e) {
           return "Yanlış oldu: " + e.getMessage();
        }
    }


}
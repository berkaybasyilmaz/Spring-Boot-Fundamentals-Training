package com.trainingspring.springasync.executor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ConcurrentController {
    private final ConcurrentPerformer concurrentPerformer;
    public ConcurrentController(ConcurrentPerformer concurrentPerformer) {
        this.concurrentPerformer = concurrentPerformer;
    }

    @GetMapping("/async/concurrent/executor")
    public String performConcurrent(){
        concurrentPerformer.doExecutor();
        return "Concurrent ( yürütümleyici ) yöntem çağırıldı.";
    }
}

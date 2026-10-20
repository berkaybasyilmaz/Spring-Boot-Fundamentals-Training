package com.trainingspring.springasync.exception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {

    private final ExceptionPerformer exceptionPerformer;
    public ExceptionController(ExceptionPerformer exceptionPerformer) {
        this.exceptionPerformer = exceptionPerformer;
    }

    @GetMapping("/async/exception/risky")
    public String performRisky() {

        exceptionPerformer.doRisky("ABC5");
        return "Riskli yöntem çağırıldı";

    }


}

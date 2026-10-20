package com.trainingspring.springevents.condition;

import com.trainingspring.springevents.application.OperationEvent;
import org.springframework.context.PayloadApplicationEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

@Component
public class ConditionListener {

    @EventListener(condition = "#event.myField.equals('GODORO')")
    public void conditionTrue(OperationEvent event) {
        System.out.println("Koşul doğru gerçekleşti: " + event.getMyField());
    }

    @EventListener(condition = "!#event.myField.equals('GODORO')")
    public void conditionFalse(OperationEvent event) {
        System.out.println("Koşul yanlış gerçekleşti: " + event.getMyField());
    }



}

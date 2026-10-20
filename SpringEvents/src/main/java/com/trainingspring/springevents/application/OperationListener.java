package com.trainingspring.springevents.application;

import org.springframework.context.ApplicationEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import javax.swing.plaf.synth.SynthSpinnerUI;

@Component // dinliyor, bir olay olunca çalışacak
public class OperationListener implements ApplicationListener<OperationEvent> {
    @Override
    public void onApplicationEvent(OperationEvent event) {
        System.out.println("Operation event received: " + event.getMyField());

    }
}

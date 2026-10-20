package com.trainingspring.springevents.application;

import org.springframework.context.ApplicationEvent;

public class OperationEvent extends ApplicationEvent {

    public String getMyField() {
        return myField;
    }

    public void setMyField(String myField) {
        this.myField = myField;
    }

    private String myField;

    public OperationEvent(Object source) {
        super(source); // bu şekilde super kullanım mantığı üst class daki const. içine bu paramtereyi yollamak
    }

    public OperationEvent(Object source, String myField) {
        super(source);
        this.myField = myField;
    }





}

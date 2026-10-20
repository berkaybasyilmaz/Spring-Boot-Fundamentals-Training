package com.trainingspring.springasync.event;

import org.springframework.context.ApplicationEvent;

public class LengthyEvent extends ApplicationEvent {

    private String myField;

    public LengthyEvent(Object source) {
        super(source);
    }


    public LengthyEvent(Object source, String myField) {
        super(source);
        this.myField = myField;
    }


    public String getMyField() {
        return myField;
    }

    public void setMyField(String myField) {
        this.myField = myField;
    }





}

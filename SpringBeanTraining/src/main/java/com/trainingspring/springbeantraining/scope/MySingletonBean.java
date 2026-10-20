package com.trainingspring.springbeantraining.scope;

public class MySingletonBean {
    public String getMyValue() {
        return "Singleton Bean" + hashCode();
    }
}

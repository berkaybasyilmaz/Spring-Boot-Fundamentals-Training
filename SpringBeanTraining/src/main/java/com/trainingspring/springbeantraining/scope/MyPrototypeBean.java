package com.trainingspring.springbeantraining.scope;

public class MyPrototypeBean {
    public String getMyValue(){
        return "Prototype Bean" + hashCode();
    }
}

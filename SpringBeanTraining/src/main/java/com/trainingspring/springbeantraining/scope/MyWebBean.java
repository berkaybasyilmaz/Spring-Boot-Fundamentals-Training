package com.trainingspring.springbeantraining.scope;

public class MyWebBean {
    public String getMyString(){

        return "Tor Bean" + hashCode();
    }
}

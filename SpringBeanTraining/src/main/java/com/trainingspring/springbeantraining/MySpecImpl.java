package com.trainingspring.springbeantraining;

public class MySpecImpl implements MySpec {

    @Override
    public String myMethod(String input) {
        return "Hello " + input;
    }
}

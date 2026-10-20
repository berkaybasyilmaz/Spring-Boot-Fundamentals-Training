package com.trainingspring.springbeantraining;

public class MyBean {

    public void initializeBean() {
        System.out.println("MyBean is initializing...");
    }

    public void finalizeBean() {
        System.out.println("MyBean is finalizing...");
    }

    public long getMyLong() {
        return MyLong;
    }

    public void setMyLong(long myLong) {
        MyLong = myLong;
    }

    public String getMyString() {
        return MyString;
    }

    public void setMyString(String myString) {
        MyString = myString;
    }

    public double getMyDouble() {
        return myDouble;
    }

    public void setMyDouble(double myDouble) {
        this.myDouble = myDouble;
    }

    long MyLong;
    String MyString;
    double myDouble;
}

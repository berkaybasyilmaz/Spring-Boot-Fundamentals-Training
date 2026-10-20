package com.trainingspring.springasync.exception;

import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;

public class ExceptionHandler implements AsyncUncaughtExceptionHandler{

    @Override
    public void handleUncaughtException(Throwable throwable, java.lang.reflect.Method method, Object... params) {
        System.out.println("Hata yakalandı: " + throwable.getMessage());
        System.out.println("Hata oluşan metod: " + method.getName());
    }
}

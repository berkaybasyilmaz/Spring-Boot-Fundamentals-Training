package com.trainingspring.springasync.executor;

import com.trainingspring.springasync.exception.ExceptionHandler;
import org.springframework.aop.interceptor.AsyncUncaughtExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.AsyncConfigurer;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;

@Configuration
@EnableAsync
public class ConcurrentConfiguration implements AsyncConfigurer {

    // Asenkron yapımızdaki Thread kullanım kapasitesi ve kuyruk ayarlarımız
    @Bean(name = "threadPoolTaskExecutor")
    Executor threadPoolTaskExecutor(){
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(5);
        executor.setQueueCapacity(50);
        executor.setMaxPoolSize(10);
        executor.initialize();
        return executor;
    }



}




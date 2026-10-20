package com.trainingspring.springbeantraining;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // Bu uygulama ayağa kalkarken kendiliğinden oluşsun
public class SourceConfiguration {

    @Bean(initMethod = "initializeBean", destroyMethod = "finalizeBean") // Bean im çalışmadan initializeBean methodunu çağır,
        // Bean im biterken finalizeBean methodunu çağır
    MyBean myBean(){
        MyBean myBean = new MyBean();
        myBean.setMyLong(301);
        myBean.setMyString("Hello, Spring!");
        myBean.setMyDouble(3.14);
        return myBean;
    }

    @Bean
    MySpec mySpec(){
        MySpecImpl mySpec = new MySpecImpl();
        return mySpec;
    }

    @Bean
    MyAgent myAgent(MyBean myBean){
        MyAgent myAgent = new MyAgent();
        myAgent.setAgentName("Ajanım");
        myAgent.setMyBean(myBean);
        return myAgent;
    }



}

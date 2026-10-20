package com.trainingspring.springbeantraining.scope;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

@Configuration
public class ScopeConfiguration {

    @Bean
    @Scope("singleton") // tek bir kopya
    MySingletonBean mySingletonBean() {
        return new MySingletonBean();
    }

    @Bean
    @Scope("prototype") // her seferinde yeni bir kopya
    MyPrototypeBean myPrototypeBean() {
        return new MyPrototypeBean();
    }
    @Bean
    @Scope("request") // her tıklamada farklı hashcode / tc olmalı.
    //prototype
    MyWebBean myRequestBean() {
        return new MyWebBean();
    }

    @Bean
    @Scope("session") // alışveriş sepeti  gibi; sayfa değiştikçe sepetin hashcode u değişmemeli mesela
    //singleton ama her siteye girişte değişen tarzda
    MyWebBean mySessionBean() {
        return new MyWebBean();
    }

    @Bean
    @Scope("application") // mesela sitede herkesin ortak gördüğü genel veriler. Her seferinde değişmemeli
    //singleton
    MyWebBean myApplicationBean() {
        return new MyWebBean();
    }
}

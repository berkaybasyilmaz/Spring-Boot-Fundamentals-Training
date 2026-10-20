package com.trainingspring.springbeantraining.scope;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ScopeController {

    private MySingletonBean mySingletonBean1;
    private MySingletonBean mySingletonBean2;
    private MyPrototypeBean myPrototypeBean;
    private MyPrototypeBean myPrototypeBean2;
    private MyWebBean myRequestBean;
    private MyWebBean mySessionBean;
    private MyWebBean myApplicationBean;

    public ScopeController(MySingletonBean mySingletonBean1, MySingletonBean mySingletonBean2, MyPrototypeBean myPrototypeBean, MyPrototypeBean myPrototypeBean2
    ,MyWebBean myRequestBean, MyWebBean mySessionBean, MyWebBean myApplicationBean) {
        this.mySingletonBean1 = mySingletonBean1;
        this.mySingletonBean2 = mySingletonBean2;
        this.myPrototypeBean = myPrototypeBean;
        this.myPrototypeBean2 = myPrototypeBean2;
        this.myRequestBean = myRequestBean;
        this.mySessionBean = mySessionBean;
        this.myApplicationBean = myApplicationBean;
    }

    @GetMapping("/scope")
    public String getSingletonOne(){
        return mySingletonBean1.getMyValue();
    }

    @GetMapping("/scope/two")
    public String getSingletonTwo(){
        return mySingletonBean2.getMyValue();
    }

    @GetMapping("/scope/prototype")
    public String getPrototypeOne(){
        return myPrototypeBean.getMyValue();
    }

    @GetMapping("/scope/prototype/two")
    public String getPrototypeTwo(){
        return myPrototypeBean2.getMyValue();
    }

    @GetMapping("/scope/all")
    public String getStrings(){
        return "Request : " + myRequestBean.getMyString() + "\n" +
                "Session: " + mySessionBean.getMyString() + "\n" +
                "Application: " + myApplicationBean.getMyString();
    }

}

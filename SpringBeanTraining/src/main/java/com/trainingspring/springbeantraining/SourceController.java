package com.trainingspring.springbeantraining;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/source")
public class SourceController {

    //@Autowired
    private MyBean myBean;
    private MySpec mySpec;
    private MyAgent myAgent;

    public SourceController(MyBean myBean ,MySpec mySpec, MyAgent myAgent) {
        this.myBean = myBean;
        this.mySpec = mySpec;
        this.myAgent = myAgent;
    }

    @GetMapping("/bean")
    public String getBean(){

        return myBean.getMyLong() + " " + myBean.getMyString() +
                " " + myBean.getMyDouble();

    }

    @GetMapping("/spec")
    public String getSpec(String input){

        return mySpec.myMethod(input);
    }

    @GetMapping("/agent")
    public String getMyAgent(){ // çıktı mesela ajanım Hello Spring ! olacak, config class ından teyitlenebilir.
        return myAgent.getAgentName() + " " + myAgent.getMyBean().getMyString();
    }

}

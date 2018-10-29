package com.karlo.dive.bootstrap.context;

import com.karlo.dive.bootstrap.listener.HelloWorldApplicationListener;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.Ordered;


public class AfterHelloWorldApplicationContext implements ApplicationContextInitializer, Ordered {

    @Override
    public void initialize(ConfigurableApplicationContext configurableApplicationContext) {
        String id = configurableApplicationContext.getId();
        configurableApplicationContext.addApplicationListener(new HelloWorldApplicationListener());
        System.out.println("AFTER application ID:"+id);
    }

    @Override
    public int getOrder() {
        return Ordered.LOWEST_PRECEDENCE;
    }
}

package com.karlo.dive.bootstrap.listener;

import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

@Order(Ordered.LOWEST_PRECEDENCE)
public class AfterHelloWorldApplicationListener
        implements ApplicationListener<ContextRefreshedEvent> {
//  这里表示监听的是context刷新事件

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        long timestamp = event.getTimestamp();
        System.out.println("after listener:"+timestamp);
    }
}

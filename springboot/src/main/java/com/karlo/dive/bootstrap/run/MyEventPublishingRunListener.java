package com.karlo.dive.bootstrap.run;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.context.event.EventPublishingRunListener;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 监听spring boot 事件/spring事件
 * springboot 通过SpringApplicationRunListener的实现类EventPublishingRunListener
 * 利用Spring Framework事件API，广播Spring Boot 事件
 *
 *
 */
public class MyEventPublishingRunListener extends EventPublishingRunListener {


    public MyEventPublishingRunListener(SpringApplication application, String[] args) {
        super(application, args);
    }

    @Override
    public void starting() {
        super.starting();
    }

    @Override
    public void environmentPrepared(ConfigurableEnvironment environment) {
        super.environmentPrepared(environment);
    }

    @Override
    public void contextPrepared(ConfigurableApplicationContext context) {
        super.contextPrepared(context);
    }

    @Override
    public void contextLoaded(ConfigurableApplicationContext context) {
        super.contextLoaded(context);
    }

    @Override
    public void started(ConfigurableApplicationContext context) {
        super.started(context);
    }

    @Override
    public void running(ConfigurableApplicationContext context) {
        super.running(context);
    }

    @Override
    public void failed(ConfigurableApplicationContext context, Throwable exception) {
        super.failed(context, exception);
    }
}

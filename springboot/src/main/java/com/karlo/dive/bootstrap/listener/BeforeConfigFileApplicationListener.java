package com.karlo.dive.bootstrap.listener;

import org.springframework.boot.context.config.ConfigFileApplicationListener;
import org.springframework.boot.context.event.ApplicationEnvironmentPreparedEvent;
import org.springframework.boot.context.event.ApplicationPreparedEvent;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.event.SmartApplicationListener;
import org.springframework.core.Ordered;
import org.springframework.core.env.ConfigurableEnvironment;

/**
 * 功能描述:
 *
 * @since: 1.0.0
 * @Author:karlo
 * @Date: 2018/10/3 17:06
 */

public class BeforeConfigFileApplicationListener implements SmartApplicationListener,Ordered {

    @Override
    public int getOrder() {
        return ConfigFileApplicationListener.DEFAULT_ORDER - 1;
    }

    @Override
    public boolean supportsEventType(Class<? extends ApplicationEvent> eventType) {
        return ApplicationEnvironmentPreparedEvent.class.isAssignableFrom(eventType)
                || ApplicationPreparedEvent.class.isAssignableFrom(eventType);
    }

    @Override
    public boolean supportsSourceType(Class<?> aClass) {
        return true;
    }

    @Override
    public void onApplicationEvent(ApplicationEvent event) {
        if (event instanceof ApplicationEnvironmentPreparedEvent) {
            ApplicationEnvironmentPreparedEvent event1 = (ApplicationEnvironmentPreparedEvent)event;
            ConfigurableEnvironment environment = event1.getEnvironment();
            String property = environment.getProperty("name", "default");
            System.out.println("getProperty default:"+property);
            String name = environment.getProperty("name");
            System.out.println("getProperty:"+name);
        }
        if (event instanceof ApplicationPreparedEvent) {
            ApplicationPreparedEvent event1 = (ApplicationPreparedEvent)event;
            ConfigurableApplicationContext applicationContext = event1.getApplicationContext();
            ConfigurableEnvironment environment = applicationContext.getEnvironment();
            String property = environment.getProperty("name", "default");
            System.out.println("getProperty default:"+property);
            String name = environment.getProperty("name");
            System.out.println("getProperty:"+name);
        }

    }
}

package com.karlo.dive.bootstrap;

import com.karlo.dive.annotation.EnableHello;
import com.karlo.dive.bootstrap.bean.ComponentTest;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * 使用@SpringbootApplication注解  可以解决根类或者配置类（我自己的说法，就是main所在类）头上注解过多的问题，
 * 一个@SpringbootApplication相当于@Configuration,@EnableAutoConfiguration和 @ComponentScan
 * 并具有他们的默认属性值
 */

@SpringBootApplication(scanBasePackages = "com.karlo.dive")
@EnableHello
//@ComponentScan(basePackages = "com.karlo.dive.bootstrap.bean")
public class AnnoStarter {


    public static void main(String[] args) {


        ConfigurableApplicationContext context = new SpringApplicationBuilder(AnnoStarter.class)
                .web(WebApplicationType.NONE)
                .run(args);
//        System.out.println("bean1 : "+bean1);
//        ComponentTest bean = (ComponentTest)context.getBean("componentTest");

//        System.out.println("bean : "+bean);
        ComponentTest bean = (ComponentTest)context.getBean("componentTest");
        Object bean1 = context.getBean("configurationBean");
        System.out.println(bean1);
//        String name = context.getClass().getName();
//        System.out.println("context 类型:"+name);
//        String name1 = context.getEnvironment().getClass().getName();
//        System.out.println("environment 类型："+name1);
        context.close();

    }
}

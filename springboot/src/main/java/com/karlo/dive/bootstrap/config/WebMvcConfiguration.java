package com.karlo.dive.bootstrap.config;

import org.springframework.boot.web.embedded.tomcat.TomcatContextCustomizer;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.boot.web.server.WebServerFactoryCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.File;

/**
 * 功能描述:
 *
 * @author karlo
 * @date 2018/10/17 22:09
 * @since 1.0.0
 */

@Configuration
public class WebMvcConfiguration  {

    /**
     * 解决maven多模块 idea无法找到jsp真正路径的问题
     *
     */
    @Bean
    public WebServerFactoryCustomizer<TomcatServletWebServerFactory> customizer(){
        return factory -> {
            factory.addContextCustomizers((TomcatContextCustomizer) context -> {
                String relativePath = "springboot/src/main/webapp";
                context.setDocBase(new File(relativePath).getAbsolutePath());
            });
        };
    }

//    @Bean
//    public InternalResourceViewResolver viewResolver(){
//        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//        resolver.setViewClass(JstlView.class);
//        resolver.setPrefix("WEB-INF/jsp/");
//        resolver.setSuffix(".jsp");
//        return resolver;
//    }


}

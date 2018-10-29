package com.karlo.web.config;

import com.karlo.web.converter.PropertiesHttpMessageConverter;
import com.karlo.web.resolver.ProperetiesMethodHandlerResolver;
import com.karlo.web.resolver.PropertiesMethodReturnValueHandlerResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerAdapter;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * 功能描述:
 *
 * @author karlo
 * @date 2018/10/22 21:44
 * @since 1.0.0
 */

@Configuration
public class MyConfiguration implements WebMvcConfigurer {

    @Autowired
    private RequestMappingHandlerAdapter adapter;

    @PostConstruct
    public void init(){
        List<HandlerMethodArgumentResolver> argumentResolvers = adapter.getArgumentResolvers();
        ArrayList<HandlerMethodArgumentResolver> resolvers = new ArrayList<>();
        resolvers.add(new ProperetiesMethodHandlerResolver());
        resolvers.addAll(argumentResolvers);
        adapter.setArgumentResolvers(resolvers);

        List<HandlerMethodReturnValueHandler> returnValueHandlers = adapter.getReturnValueHandlers();
        ArrayList<HandlerMethodReturnValueHandler> handlers = new ArrayList<>();
        handlers.add(new PropertiesMethodReturnValueHandlerResolver());
        handlers.addAll(returnValueHandlers);
        adapter.setReturnValueHandlers(handlers);

    }


    @Override
    public void extendMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(new PropertiesHttpMessageConverter());
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> resolvers) {

        //手动添加一个resolver
//        if(resolvers.isEmpty()){
//            resolvers.add(new ProperetiesMethodHandlerResolver());
//        }else{
//            resolvers.set(0,new ProperetiesMethodHandlerResolver());
//        }

    }
}

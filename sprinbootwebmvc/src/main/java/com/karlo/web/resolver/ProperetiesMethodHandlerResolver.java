package com.karlo.web.resolver;

import org.springframework.core.MethodParameter;
import org.springframework.http.MediaType;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * 功能描述:
 *
 * @author karlo
 * @date 2018/10/23 20:25
 * @since 1.0.0
 */

public class ProperetiesMethodHandlerResolver implements HandlerMethodArgumentResolver {


    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        return Properties.class.equals(parameter.getParameterType());
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer,
                 NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        ServletWebRequest request = (ServletWebRequest) webRequest;
        HttpServletRequest servletRequest = request.getRequest();
        String contentType = servletRequest.getContentType();
        System.out.println("request.getContentType():"+contentType);
        String contentType1 = servletRequest.getHeader("Content-Type");
        System.out.println("servletRequest.getHeader():"+contentType1);
        Properties properties = new Properties();
        MediaType mediaType = MediaType.parseMediaType(contentType1);
        Charset charset = mediaType.getCharset();
        charset = charset == null ? Charset.forName("UTF-8") : charset;
        InputStream inputStream = servletRequest.getInputStream();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
        properties.load(inputStreamReader);

        return properties;
    }
}

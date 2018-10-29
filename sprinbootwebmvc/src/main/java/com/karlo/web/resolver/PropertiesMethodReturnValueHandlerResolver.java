package com.karlo.web.resolver;

import com.karlo.web.converter.PropertiesHttpMessageConverter;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.server.ServletServerHttpResponse;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Properties;

/**
 * 功能描述:
 *
 * @author karlo
 * @date 2018/10/28 12:25
 * @since 1.0.0
 */

public class PropertiesMethodReturnValueHandlerResolver implements HandlerMethodReturnValueHandler {
    @Override
    public boolean supportsReturnType(MethodParameter returnType) {

        return Properties.class.equals(returnType.getMethod().getReturnType());
    }

    @Override
    public void handleReturnValue(Object returnValue, MethodParameter returnType,
                                  ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {
        PropertiesHttpMessageConverter converter = new PropertiesHttpMessageConverter();
        Properties properties = (Properties)returnValue;
        ServletWebRequest servletWebRequest = (ServletWebRequest) webRequest;
        HttpServletRequest request = servletWebRequest.getRequest();
        HttpServletResponse response = servletWebRequest.getResponse();
        String contentType = request.getContentType();
        MediaType mediaType = MediaType.parseMediaType(contentType);
//        Charset charset = mediaType.getCharset();
//        charset = charset == null ? Charset.forName("UTF-8") :charset;
        HttpOutputMessage outputMessage = new ServletServerHttpResponse(response);
        converter.write(properties,mediaType,outputMessage);

        mavContainer.setRequestHandled(true);
    }
}

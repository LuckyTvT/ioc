package com.karlo.web.converter;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractGenericHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;

import java.io.*;
import java.lang.reflect.Type;
import java.nio.charset.Charset;
import java.util.Properties;

/**
 * 功能描述:
 *
 * @author karlo
 * @date 2018/10/22 21:45
 * @since 1.0.0
 */

public class PropertiesHttpMessageConverter extends AbstractGenericHttpMessageConverter<Properties> {

    //这里需要通过构造方法来设置支持的媒体类型
    public PropertiesHttpMessageConverter() {
        super(new MediaType("text","properties"));
    }

    @Override
    protected void writeInternal(Properties properties, Type type, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        OutputStream outputStream = outputMessage.getBody();
        HttpHeaders headers = outputMessage.getHeaders();
        MediaType contentType = headers.getContentType();
        Charset charset = contentType.getCharset();
        charset = charset==null?Charset.forName("UTF-8") :charset;
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream, charset);
        properties.store(outputStreamWriter,"这里相当于注释");

    }

    @Override
    protected Properties readInternal(Class<? extends Properties> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        //将输入信息转换成Properties对象
        Properties properties = new Properties();
        InputStream inputStream = inputMessage.getBody();
        HttpHeaders headers = inputMessage.getHeaders();
        MediaType contentType = headers.getContentType();
        Charset charset = contentType.getCharset();
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream, charset);
        properties.load(inputStreamReader);
        return properties;
    }

    @Override
    public Properties read(Type type, Class<?> contextClass, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return readInternal(null,inputMessage);
    }
}

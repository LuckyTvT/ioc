package com.karlo.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;

/**
 * 功能描述:切面通知注解
 *
 * @since: 1.0.0
 * @Author:karlo
 * @Date: 2018/10/6 17:08
 */

@ControllerAdvice(assignableTypes = TestController.class)
public class TestControllerAdvice {

//    @ModelAttribute("JsessionID")
//    public String getSessionId(@CookieValue("JSESSIONID") String sessionId){
//        return sessionId;
//    }

    @ModelAttribute("message")
    public String setMessage(){
        return "hello world";
    }

    /**
     * 全局异常处理
     * @param throwable
     * @return
     */
    @ExceptionHandler(Throwable.class)
    public ResponseEntity<String> onException(Throwable throwable){

        return ResponseEntity.ok(throwable.getMessage());

    }

}

package com.karlo.web.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;

import java.util.List;

/**
 * 功能描述:
 *
 * @author karlo
 * @date 2018/10/21 12:58
 * @since 1.0.0
 */

@ControllerAdvice(
        assignableTypes = {Test1Controller.class}
        )
public class Test1ControllerAdvice {
    @ExceptionHandler({Throwable.class})
    public ResponseEntity exHandler(Throwable throwable) {
        System.out.println("全局异常处理！");
        return ResponseEntity.ok(throwable.getMessage());
    }

    @ModelAttribute("ipList")
    public List<String> getIpList(@RequestAttribute List<String> ipList) {
        return ipList;
    }
}

package com.karlo.dive.bootstrap.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 功能描述:
 *
 * @author karlo
 * @date 2018/10/17 22:28
 * @since 1.0.0
 */

@Controller
public class TestController {

    @RequestMapping("")
    public String index(){
        System.out.println(11111);
        return "index";
    }

}

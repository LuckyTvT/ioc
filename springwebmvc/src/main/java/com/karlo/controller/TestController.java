package com.karlo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * 功能描述:
 *
 * @since: 1.0.0
 * @Author:karlo
 * @Date: 2018/10/4 18:25
 */

@Controller
public class TestController {


    @RequestMapping("")
    public String index(@RequestParam int value, Model model){
        return "index";
    }




}

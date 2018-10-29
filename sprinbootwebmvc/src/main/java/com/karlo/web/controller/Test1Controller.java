package com.karlo.web.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

/**
 * 功能描述:
 *
 * @author karlo
 * @date 2018/10/21 12:55
 * @since 1.0.0
 */

@Controller
public class Test1Controller {

    @RequestMapping("/rest")
    @ResponseBody
    public Map<String, Object> rest(@RequestParam(required = false) String message) throws IOException {
        Map<String, Object> map = new HashMap();
        map.put("message", message);
        map.put("code", 1);
        return map;
    }

//    @PostMapping("/getList")
//    public String getIpList(){
//        return "ipList";
//    }

    @RequestMapping(value = "/return/prop",
            consumes = "text/properties")
    public Properties test(Properties properties){
        return properties;
    }

}

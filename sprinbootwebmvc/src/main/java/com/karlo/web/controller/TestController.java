package com.karlo.web.controller;

import com.karlo.web.domain.User;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * 功能描述:
 *
 * @author karlo
 * @date 2018/10/20 15:00
 * @since 1.0.0
 */

@RestController
public class TestController {

    @PostMapping("")
    public User getUser(@RequestBody User user){
        return user;
    }

    @GetMapping("/map")
    public Map<String,Object> getMap(){
        Map<String, Object> map = new HashMap<>();
        map.put("code",1);
        map.put("message","返回了map");
        return map;
    }

    @PostMapping("/getList")
    public Map<String,Object> getIpList(@RequestBody String ip,
                                        @RequestAttribute List<String> ipList){
        Map<String, Object> map = new HashMap<>();
        map.put("code",1);
        map.put("ipList",ipList);
        return map;
    }

    @PostMapping(value = "/add/props",
            consumes = "text/properties;charset=UTF-8")
    public Properties props(@RequestBody Properties properties){
        return properties;
    }

    @PostMapping(value = "/add/prop",
            consumes = "text/properties;charset=UTF-8")
    public Properties prop(Properties properties){
        return properties;
    }

}

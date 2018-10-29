package com.karlo.dive.bootstrap.bean;

import org.springframework.context.annotation.Bean;

/**
 * 功能描述:
 *
 * @author karlo
 * @date 2018/10/14 17:21
 * @since 1.0.0
 */


public class ConfigurationBean {

    @Bean
    public String configurationBean(){
        return "configurationBean";
    }

}

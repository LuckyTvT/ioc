package com.karlo.servlet.surport;

import com.karlo.config.DispatcherServletConfiguration;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

/**
 * 功能描述:
 *
 * spring Web Mvc 自动装配  自定义的默认实现
 *
 *
 * @since: 1.0.0
 * @Author:karlo
 * @Date: 2018/10/7 12:13
 */

public class DefaultWebApplication extends AbstractAnnotationConfigDispatcherServletInitializer {
    @Override
    protected Class<?>[] getRootConfigClasses() {  //对应 web.xml内一些配置
        return new Class[0];
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {// 配置DispatherServlet
        return new Class[]{DispatcherServletConfiguration.class};
    }

    @Override
    protected String[] getServletMappings() { //配置servlet的映射
        return new String[]{"/"};
    }
}

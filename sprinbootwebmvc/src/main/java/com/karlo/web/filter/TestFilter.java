package com.karlo.web.filter;

import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * 功能描述:
 *
 * @author karlo
 * @date 2018/10/21 12:46
 * @since 1.0.0
 */
@WebFilter(
        filterName = "testFilter",
        urlPatterns = {"/*"}
)
@Component
public class TestFilter implements Filter {
    private AtomicInteger count = new AtomicInteger(0);

    private List<String> ipList = new ArrayList<>();

    public List<String> getIpList() {
        return ipList;
    }

    public void setIpList(List<String> ipList) {
        this.ipList = ipList;
    }

    public TestFilter() {
    }

    public void init(FilterConfig filterConfig) throws ServletException {
        ServletContext context = filterConfig.getServletContext();
        System.out.println("servletContextName:" + context.getServletContextName());
        System.out.println("这里初始化了filter");
    }

    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.out.println("这里执行了过滤方法！");
        int i = this.count.incrementAndGet();
        System.out.println("你是第" + i + "个访问的人！");
        request.setAttribute("count", i);
        if(request instanceof HttpServletRequest){
            String ipAddress = getIpAddress((HttpServletRequest) request);
            if(!ipList.contains(ipAddress)){
                ipList.add(ipAddress);
            }
            request.setAttribute("ipList",ipList);

        }else{
            System.out.println("无法获取ip");
        }
        chain.doFilter(request, response);
    }

    public void destroy() {
        System.out.println("这里销毁了filter");
    }

    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        return ip;
    }
}

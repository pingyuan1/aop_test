package com.aop.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author ：pingyuan
 * @description：TODO
 * @date ：2021/6/16 19:42
 */
//@WebFilter(filterName = "ChainFilter1", urlPatterns = "/aops/*")
public class ChainFilter1 implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        HttpServletRequest request1 = (HttpServletRequest) request;
        if (request1.getRequestURL().toString().matches(".+.ico$")){
            return;
        }
        System.out.println("进入到ChainFilter1过滤器");
        chain.doFilter(request,response);
        System.out.println("进入到ChainFilter1过滤器---结束");
    }

    @Override
    public void destroy() {

    }
}

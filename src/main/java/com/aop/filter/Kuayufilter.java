package com.aop.filter;

import org.apache.catalina.filters.HttpHeaderSecurityFilter;

import javax.servlet.*;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author ：pingyuan
 * @description：TODO
 * @date ：2021/6/17 14:20
 */
public class Kuayufilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response1, FilterChain chain) throws IOException, ServletException {
        //设置跨域请求
        HttpServletResponse response = (HttpServletResponse) response1;
        //此处ip地址为需要访问服务器的ip及端口号 也可以设置为*表示所有域都可以通过；
        response.setHeader("Access-Control-Allow-Origin", "*");
        //表示的是跨域的ajax中可以携带cookie，此时第一项设置不能为*，需指定域名；
        response.setHeader("Access-Control-Allow-Credentials", "true");
        //表示的是允许跨域的请求方法；
        response.setHeader("Access-Control-Allow-Methods", "GET, HEAD, POST, PUT, DELETE, TRACE, OPTIONS, PATCH");
        //表示的是允许跨域请求包含content-type头；
        response.setHeader("Access-Control-Allow-Headers", "Origin, X-Requested-With, Content-Type,Authorization,Token,Accept, Connection, User-Agent, Cookie");
        //表示的是在3628800秒内，不需要再发送预检验请求，可以缓存该结果，一般默认。
        response.setHeader("Access-Control-Max-Age", "3628800");

        System.out.println("设置跨域请求");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {

    }
}

package com.aop.filter;

import javax.servlet.*;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.text.SimpleDateFormat;

/**
 * @author ：pingyuan
 * @description：TODO
 * @date ：2021/6/16 16:54
 */
@WebFilter(filterName = "securityRequestFilter", urlPatterns = "/param/ge")
public class MyFliter implements Filter {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {

        HttpServletRequest hrequest = (HttpServletRequest) request;
        if (hrequest.getRequestURL().toString().matches(".+.ico$")){
            chain.doFilter(request,response);
            return;
        }
        long startTime = System.currentTimeMillis(); // 请求进入时间
        System.out.println("开始时间："+sdf.format(startTime));
        System.out.println("url:"+hrequest.getRequestURL());
        System.out.println("方法："+hrequest.getMethod());
        //放行
        chain.doFilter(request,response);
        //结束时间
        long endTime = System.currentTimeMillis();
        System.out.println("结束时间："+sdf.format(endTime));
        System.out.println("用时："+String.valueOf(endTime-startTime));

    }

    @Override
    public void destroy() {

    }
}

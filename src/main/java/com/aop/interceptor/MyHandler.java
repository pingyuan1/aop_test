package com.aop.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author ：pingyuan
 * @description：TODO
 * @date ：2021/7/6 17:01
 */
public class MyHandler implements HandlerInterceptor {

    public final AtomicLong count = new AtomicLong();// 计数器
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println(request.getRequestURL());
        long begin_nao_time = System.nanoTime();
        request.setAttribute(request.getRequestURL()+"begin_nao_time", begin_nao_time);
        System.out.println("count:"+count);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

        long end_nao_time = System.nanoTime();
        long begin = (Long) request.getAttribute(request.getRequestURL()+"begin_nao_time");
        System.out.println("耗时："+String.valueOf(end_nao_time-begin));

    }
}

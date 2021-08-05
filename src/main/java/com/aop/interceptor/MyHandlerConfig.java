package com.aop.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author ：pingyuan
 * @description：TODO
 * @date ：2021/7/6 17:01
 */
@Configuration
public class MyHandlerConfig implements WebMvcConfigurer {

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration interceptorRegistration = registry.addInterceptor(new MyHandler());
        interceptorRegistration.addPathPatterns("/handler/*");

        interceptorRegistration.excludePathPatterns("/aops/*");
    }
}

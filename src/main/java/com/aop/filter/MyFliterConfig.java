package com.aop.filter;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ：pingyuan
 * @description：TODO
 * @date ：2021/6/16 17:12
 */
@Configuration
public class MyFliterConfig {

    @Bean
    public FilterRegistrationBean getKuayu(){
        FilterRegistrationBean bean = new FilterRegistrationBean();
        bean.setFilter(new Kuayufilter());
        bean.addUrlPatterns("/aop/*");
        return bean;
    }


    @Bean
    public FilterRegistrationBean get(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new MyFliter());
        List<String> list = new ArrayList<>();
        list.add("/aop/*");
        filterRegistrationBean.addUrlPatterns("/aop/*");
//        filterRegistrationBean.setUrlPatterns(list);
        return filterRegistrationBean;
    }
    @Bean FilterRegistrationBean getChain1(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new ChainFilter1());
        filterRegistrationBean.addUrlPatterns("/aop/*");
        return filterRegistrationBean;
    }
    @Bean FilterRegistrationBean getChain2(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new ChainFilter2());
        filterRegistrationBean.addUrlPatterns("/aop/*");
        return filterRegistrationBean;
    }
    @Bean FilterRegistrationBean getChain3(){
        FilterRegistrationBean filterRegistrationBean = new FilterRegistrationBean();
        filterRegistrationBean.setFilter(new ChainFilter3());
        filterRegistrationBean.addUrlPatterns("/handler1/*");
        return filterRegistrationBean;
    }


}

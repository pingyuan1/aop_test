package com.aop;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.FilterRegistration;

/**
 * Hello world!
 *
 */
//@SpringBootApplication(exclude={DataSourceAutoConfiguration.class})
@SpringBootApplication
//@ServletComponentScan("com.aop.filter")
public class App {
    public static void main(String[] args) {
        SpringApplication.run(App.class, args);
    }
 /*@Autowired
    private RestTemplateBuilder builder;

    @Bean
    public RestTemplate restTemplate() {
        return builder.build();
    }*/


    /**
     * 实现跨域的全局配置
     *
     * @return
     */
    @Bean
    public WebMvcConfigurer corsConfigurer() {
        return new WebMvcConfigurerAdapter() {
            @Override
            public void addCorsMappings(CorsRegistry registry) {
                registry.addMapping("/**")    // 允许跨域访问的路径
                        .allowedOrigins("*")    // 允许跨域访问的源
                        .allowedMethods("POST", "GET", "PUT", "OPTIONS", "DELETE")    // 允许请求方法
                        .maxAge(168000)    // 预检间隔时间
                        .allowedHeaders("*")  // 允许头部设置
                        .allowCredentials(true);    // 是否发送cookie
            }
        };
    }

}


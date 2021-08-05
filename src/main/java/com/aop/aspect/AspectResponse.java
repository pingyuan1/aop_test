package com.aop.aspect;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author ：pingyuan
 * @description：TODO
 * @date ：2021/6/10 10:27
 */
@Component
@Aspect
public class AspectResponse {

    @Pointcut("execution(protected * com.aop.service.Impl.*.*(..))")
    public void webLog(){
    }

//    @Before("webLog()")
//    public void before(JoinPoint proceedingJoinPoint){
//        // 接收到请求，记录请求内容
//        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletRequest request = attributes.getRequest();
//        System.out.println("URL : " + request.getRequestURL().toString());
//        System.out.println("HTTP_METHOD : " + request.getMethod());
//        System.out.println("CLASS_METHOD : " + proceedingJoinPoint.getSignature().getDeclaringTypeName() + "." + proceedingJoinPoint.getSignature().getName());
//    }
//
//    @AfterReturning(returning = "ret", pointcut = "webLog()")
//    public void doAfterReturning(Object ret) throws Throwable {
//        // 处理完请求，返回内容
//        int a = 1;
//        System.out.println("方法的返回值 : " + ret);
//    }
//
//    //后置异常通知
//    @AfterThrowing(value = "webLog()",throwing = "ex")
//    public void throwss(JoinPoint jp,RuntimeException ex){
//        System.out.println(jp.getSignature().getName()+"该方法发生异常");
//        System.out.println(ex.getMessage().toString());
//        System.out.println("方法异常时执行.....");
//    }
//
//    //后置最终通知,final增强，不管是抛出异常或者正常退出都会执行
//    @After("webLog()")
//    public void after(JoinPoint jp){
//        int a = 1;
//        System.out.println("方法最后执行.....");
//    }

    //环绕通知,环绕增强，相当于MethodInterceptor
    @Around("webLog()")
    public void arround(ProceedingJoinPoint pjp) throws Throwable {
        try {
            try {

                ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
                HttpServletRequest request = servletRequestAttributes.getRequest();
                System.out.println("请求地址："+request.getRequestURL());
                System.out.println("请求方法："+request.getMethod());
                Object proceed = pjp.proceed();
                System.out.println(proceed.toString());
                System.out.println("方法名："+pjp.getSignature().getName()+"");
                System.out.println("入参："+request.getParameterMap());
                //入参获取

                //参数存入map
                Map<String,Object> map = new HashMap<>();
                Object[] args = pjp.getArgs();
                for (Object param : args) {
                    System.out.println("参数："+param);
                }

            } catch (Throwable throwable) {
                throwable.printStackTrace();
            }finally {
                System.out.println("结果："+pjp.proceed());
            }
            System.out.println("");
        }catch (Exception e){

            System.out.println("异常paochu："+e);
        }
    }

}

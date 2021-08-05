package com.aop.aspect;

import com.aop.annotation.AopAnnotation;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

/**
 * @author ：pingyuan
 * @description：TODO
 * @date ：2021/6/16 14:21
 */
@Component
@Aspect
public class AnnotationAop {

//    @Pointcut("@annotation(com.aop.annotation.AopAnnotation)")
//    public void get1(){
//    }
//    @Around("get1()")
//    public Object getAop(ProceedingJoinPoint joinPoint){
//        return null;
//    }
    @Around("@annotation(com.aop.annotation.AopAnnotation)")
    public Object getAop(ProceedingJoinPoint joinPoint) throws Throwable{
        Object object = null;
        try {
            //方法前操作
            String methodName = joinPoint.getSignature().getName();
            Class tarClass = joinPoint.getTarget().getClass();
            Method[] methods = tarClass.getMethods();
            Method metho = null;
            for (Method method : methods) {
                if (method.getName().equals(methodName)){
                    metho = method;
                }
            }
            AopAnnotation annotation = metho.getAnnotation(AopAnnotation.class);
            String name1 = annotation.name();
            int value = annotation.value();
            System.out.println(name1);
            System.out.println(value);
            System.out.println("方法前操作");
            Object[] args = joinPoint.getArgs();
            String className = joinPoint.getTarget().getClass().getSimpleName();
            System.out.println(className);
            StringBuilder sb = new StringBuilder();
            for (Object arg : args) {
                sb.append(arg.getClass().getSimpleName()+"="+arg);
            }
            System.out.println(sb.toString());
            String name = joinPoint.getSignature().getName();
            System.out.println(name);
            object = joinPoint.proceed();

        }catch (Exception e){
            System.out.println(e);
        }
        //方法返回值

        String toString = (String)object.getClass().getMethod("toString").invoke(object);
        System.out.println(toString);
        return null;
    }
}

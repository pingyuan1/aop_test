package com.aop.aspect;

import com.aop.common.Response;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ：pingyuan
 * @description：TODO
 * @date ：2021/6/16 9:07
 */
@Component
@Aspect
public class AroundAspect {

    @Around(value = "execution(protected * com.aop.service.Impl.*.*(..))")
    public Object around(ProceedingJoinPoint pjp) throws Throwable{

        Object returnObject = null;
        try {
            //传参参数
            logRequestContext(pjp);
            //返回值
            returnObject = pjp.proceed();
        }catch (Throwable throwable){
            returnObject = constructExceptionResponse(pjp, throwable);
            ServletRequestAttributes servletRequestAttributes = (ServletRequestAttributes)RequestContextHolder.getRequestAttributes();
            HttpServletRequest request = servletRequestAttributes.getRequest();
            System.out.println(request.getParameterMap());
        }
        logResponseContext(returnObject);
        return returnObject;
    }

    private Object constructExceptionResponse(ProceedingJoinPoint pjp, Throwable throwable) throws IllegalAccessException, InstantiationException {
        //异常
        System.out.println("异常打印");
        Object returnObj = null;
        Method method = getMethod(pjp);
        Class<?> returnType = method.getReturnType();
        //返回值类型 void/其他
        String name = returnType.getName();
        if ("void".equals(name)){
            returnObj = new Response<>();
        }else {
            returnObj = returnType.newInstance();
        }
        if (throwable instanceof Throwable){
            System.out.println("异常抛出:"+throwable);
        }
        return returnObj;
    }

    private Method getMethod(ProceedingJoinPoint pjp) {
        Class aClass = pjp.getTarget().getClass();
        String name = pjp.getSignature().getName();
        System.out.println(name);
        for (Method method : aClass.getMethods()) {
            if (method.getName().equals(name)){
                return method;
            }
        }
        return null;
    }

    private void logResponseContext(Object returnObject) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        System.out.println("返回值");
        System.out.println(returnObject.getClass().getMethod("toString").invoke(returnObject));
    }

    private void logRequestContext(ProceedingJoinPoint joinPoint) {
        //传参
        Object[] args = joinPoint.getArgs();
        StringBuilder stb = new StringBuilder();
        for (Object arg : args) {
            stb.append(arg.getClass().getSimpleName()+"="+arg.toString());
        }
        System.out.println("传参");
        System.out.println(joinPoint.getTarget().getClass().getSimpleName());
        System.out.println(joinPoint.getSignature());
        System.out.println(joinPoint.getSignature().getName());
        System.out.println(stb.toString());
    }
}

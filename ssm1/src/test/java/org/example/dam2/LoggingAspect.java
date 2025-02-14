package org.example.dam2;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;

// 定义切面类
@Aspect
@Component
public class LoggingAspect {

    // 前置通知，在方法执行前记录日志
    @Before("@annotation(Loggable)")
    public void beforeMethod(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Loggable loggable = method.getAnnotation(Loggable.class);
        String level = loggable.level();
        System.out.println("[" + level + "] Before method: " + method.getName());
    }

    // 后置通知，在方法执行后记录日志
    @After("@annotation(Loggable)")
    public void afterMethod(JoinPoint joinPoint) {
        MethodSignature signature = (MethodSignature) joinPoint.getSignature();
        Method method = signature.getMethod();
        Loggable loggable = method.getAnnotation(Loggable.class);
        String level = loggable.level();
        System.out.println("[" + level + "] After method: " + method.getName());
    }
}
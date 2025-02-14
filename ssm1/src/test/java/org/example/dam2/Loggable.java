package org.example.dam2;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

// 定义一个自定义注解，用于标记需要记录日志的方法
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Loggable {
    // 可以定义一些属性，这里简单定义一个日志级别属性
    String level() default "INFO";
}
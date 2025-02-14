package org.example.dam1;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

public class TestZhuJie {
    @Loggable(level = "DEBUG", message = "Creating a new user", enabled = false)
    public void createUser(String username) {
        System.out.println("Creating user: " + username);
    }

    // 如果注解中定义了名为 value 的属性，不指定属性名时参数会赋给 value
    // 这里我们修改 Loggable 注解添加 value 属性
    // 重新定义 Loggable 注解
    @Retention(RetentionPolicy.RUNTIME)
    @Target(ElementType.METHOD)
    @interface Loggable {
        // 定义 value 属性
        String value() default "";
        String level() default "INFO";
        String message() default "";
        boolean enabled() default true;
    }

    // 使用注解时不指定属性名，参数会赋给 value
    @Loggable(level = "This is a special log message")
    public void updateUser(String username) {
        System.out.println("Updating user: " + username);
    }
}

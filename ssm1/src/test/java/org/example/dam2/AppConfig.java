package org.example.dam2;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

// 配置类
@Configuration
@ComponentScan(basePackages = "org.example.dam2")
@EnableAspectJAutoProxy
public class AppConfig {

    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserService userService = context.getBean(UserService.class);
        userService.createUser("JohnDoe");
        context.close();
    }
}

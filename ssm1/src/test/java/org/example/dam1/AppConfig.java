package org.example.dam1;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

// Spring 配置类
@Configuration
@ComponentScan(basePackages = "org.example.dam1")
class AppConfig {
    // 这里没有显式配置 Bean，Spring 会自动扫描并管理 MyBean
}
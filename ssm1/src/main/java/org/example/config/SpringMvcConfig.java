package org.example.config;

import org.example.controller.interceptor.ProjectInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
@ComponentScan({"org.example.controller", "org.example.config"})
@EnableWebMvc
public class SpringMvcConfig {

}

// 下面的方式等价于导入SpringMvcSupport, 这样就不用写@ComponentScan("org.example.config")了

//public class SpringMvcConfig implements WebMvcConfigurer{
//
//    //    @Autowired
//    private final ProjectInterceptor projectInterceptor;
//
//    @Autowired
//    public SpringMvcConfig(ProjectInterceptor projectInterceptor) {
//        this.projectInterceptor = projectInterceptor;
//    }
//
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(projectInterceptor).addPathPatterns("/books/**");
//    }
//
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/pages/**").addResourceLocations("/pages/");
//        registry.addResourceHandler("/js/**").addResourceLocations("/js/");
//        registry.addResourceHandler("/css/**").addResourceLocations("/css/");
//        registry.addResourceHandler("/plugins/**").addResourceLocations("/plugins/");
//    }
//}

package org.example.dam1;

import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // 创建 Spring 容器
        ConfigurableApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);

        // 从容器中获取 MyBean 实例
        MyBean myBean = context.getBean(MyBean.class);

        // 调用 Bean 的方法进行操作
        myBean.doSomething();

        // 关闭 Spring 容器
        context.close();

        // 尝试再次调用 Bean 的方法
        myBean.doSomething();

        TestZhuJie zhujie = new TestZhuJie();
        zhujie.updateUser("testzhujielei");
        zhujie.createUser("testzhujie2");
    }
}

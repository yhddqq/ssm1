package org.example.dam1;

import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.stereotype.Component;

// 定义一个实现 InitializingBean 和 DisposableBean 接口的 Bean
@Component
class MyBean implements InitializingBean, DisposableBean {
    private boolean isResourceOpen;

    public MyBean() {
        this.isResourceOpen = false;
        System.out.println("MyBean 实例被创建");
    }

    // 实现 InitializingBean 接口的 afterPropertiesSet 方法，用于初始化操作
    @Override
    public void afterPropertiesSet() throws Exception {
        System.out.println("MyBean 执行初始化操作，打开资源");
        this.isResourceOpen = true;
    }

    // 实现 DisposableBean 接口的 destroy 方法，用于销毁操作
    @Override
    public void destroy() throws Exception {
        if (isResourceOpen) {
            System.out.println("MyBean 执行销毁操作，关闭资源");
            this.isResourceOpen = false;
        }
    }

    public void doSomething() {
        if (isResourceOpen) {
            System.out.println("MyBean 正在使用打开的资源进行操作");
        } else {
            System.out.println("资源未打开，无法进行操作");
        }
    }
}
package org.example.dam2;

import org.springframework.stereotype.Service;

// 业务类
@Service
public class UserService {

    // 使用自定义注解标记需要记录日志的方法
    @Loggable(level = "DEBG2")
    public void createUser(String username) {
        System.out.println("Creating user: " + username);
    }
}
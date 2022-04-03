package com.example.demo_backend;

import com.example.demo_backend.bean.User;
import com.example.demo_backend.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class DemoBackendApplicationTests {

    @Autowired
    private UserService userService;

    @Test
    void contextLoads() {
    }

    @Test
    void insertUser() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("admin");
        user.setEmail("abc@abc.com");
        user.setTel("1234");
        System.out.println(userService.insertUser(user));
    }

    @Test
    void login() {
        User user = userService.findByUsername("admin");
        System.out.println(user.getPassword());
    }
}

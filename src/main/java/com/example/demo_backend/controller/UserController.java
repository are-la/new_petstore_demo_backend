package com.example.demo_backend.controller;

import com.example.demo_backend.bean.User;
import com.example.demo_backend.response.LoginResponse;
import com.example.demo_backend.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/")
    public User getUser() {
        return userService.findByUsername("admin");
    }
    @PostMapping("/login")
    public Object login(@RequestBody User user) {
        System.out.println(user.getUsername());
        User user1 = userService.findByUsername(user.getUsername());
        LoginResponse loginResponse = new LoginResponse();
        if (user1 == null) {
            loginResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
            loginResponse.setMessage("User not exist");
            return new ResponseEntity(loginResponse, HttpStatus.BAD_REQUEST);
        } else if (!user1.getPassword().equals(user.getPassword())) {
            loginResponse.setHttpStatus(HttpStatus.BAD_REQUEST);
            loginResponse.setMessage("User password error");
            return new ResponseEntity(loginResponse, HttpStatus.BAD_REQUEST);
        }
        loginResponse.setMessage("Login success");
        loginResponse.setToken("123");
        loginResponse.setHttpStatus(HttpStatus.OK);
        return loginResponse;
    }
}

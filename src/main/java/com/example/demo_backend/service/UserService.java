package com.example.demo_backend.service;

import com.example.demo_backend.bean.User;
import com.example.demo_backend.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

//    public UserService(UserMapper userMapper) {
//        this.userMapper = userMapper;
//    }

    public Boolean insertUser(User user) {
        return userMapper.insertUser(user);
    }

    public User findByUsername(String username) {
        return userMapper.findUserByUsername(username);
    }
}

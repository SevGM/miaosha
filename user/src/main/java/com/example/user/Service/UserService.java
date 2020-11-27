package com.example.user.Service;

import com.example.user.Entity.User;

import java.util.Map;

public interface UserService {
    Map<String, Object> login(User user);
    Map<String, Object> insertUser(User user);
}

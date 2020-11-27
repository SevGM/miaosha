package com.example.user.Controller;

import com.example.user.Entity.User;
import com.example.user.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping(value = "/login")
    public Map<String, Object> login(@RequestBody User user){
        return userService.login(user);
    }

    @PostMapping(value = "/signup")
    public Map<String, Object> signup(@RequestBody User user){
        return userService.insertUser(user);
    }

}

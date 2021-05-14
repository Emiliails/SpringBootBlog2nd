package com.niu.demo.controller;

import com.niu.demo.entity.User;
import com.niu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/addUser")
    public String addUser() {
        return "addUser";
    }

    @PostMapping("/addUser")
    @ResponseBody
    public User addUser(User user) {
        userService.add(user);
        return user;
    }

    @GetMapping("/getUsers")
    @ResponseBody
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/login")
    public String login(User user) {
        return "login";
    }

    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }
}

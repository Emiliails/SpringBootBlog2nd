package com.niu.demo.controller;

import com.niu.demo.entity.User;
import com.niu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/register")
    public String addUser() {
        return "addUser";
    }

    @PostMapping("/register")
    public String addUser(User user) {
        userService.addUser(user);
        return "addUserResult";
    }

    @GetMapping("/listUsers")
    public String findAll(Model model) {
        List<User> users = userService.findAll();
        model.addAttribute("users", users);
        return "listUsers";
    }
}

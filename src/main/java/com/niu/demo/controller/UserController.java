package com.niu.demo.controller;

import com.niu.demo.entity.User;
import com.niu.demo.service.UserService;
import jdk.nashorn.internal.runtime.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/addUser")
    @ResponseBody
    public User addUser() {
        User user = new User();
        user.setUserName("syl");
        user.setPassword("ss");

        return userService.add(user);
    }

    @PostMapping("/addUser")
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

    @GetMapping("/login")
    public String login(User user) {
        return "login";
    }

    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }
}

package com.niu.demo.controller;

import com.niu.demo.entity.User;
import com.niu.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
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

    @GetMapping("/modifyUser")
    public String modifyUser(Model model, @RequestParam("userId") int userId) {
        User user = userService.findById(userId);
        model.addAttribute(user);
        return "modifyUser";
    }

    @PostMapping("/modifyUser")
    @ResponseBody
    public User modifyUser(int userId, String userName, String password, String name, String gender, String birthday,
                           String phone, String email, String wechat, String description) {
        return userService.modify(userId, userName, password, name, gender, birthday, phone, email, wechat, description);
    }

    @GetMapping("/modifyCurrentUser")
    public String modifyCurrentUser(Model model) {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        model.addAttribute(user);
        return "modifyCurrentUser";
    }

    @GetMapping("/manageUsers")
    public String manageUsers(Model model) {
        List<User> userList = userService.findAll();
        model.addAttribute(userList);
        return "manageUsers";
    }

    @GetMapping("/getUsers")
    @ResponseBody
    public List<User> getUsers() {
        return userService.findAll();
    }

    @GetMapping("/searchUser")
    public String searchUser() {
        return "searchUser";
    }

    @PostMapping("/searchUser")
    public String searchUser(Model model, String userNameLike) {
        List<User> userList = userService.findByUserNameLike(userNameLike);
        model.addAttribute(userList);
        return "searchUser";
    }


    @GetMapping("/login")
    public String login(User user) {
        return "login";
    }

    @GetMapping(value = {"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("/displayUser")
    public String displayUser(Model model, int userId) {
        User user = userService.findById(userId);
        model.addAttribute(user);
        return "displayUser";
    }

    @GetMapping("/displayCurrentUser")
    public String displayCurrentUser(Model model) {

        //        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        int userId = ((User) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getUserId();
        User user = userService.findById(userId);

        model.addAttribute(user);
        return "displayUser";
    }
}

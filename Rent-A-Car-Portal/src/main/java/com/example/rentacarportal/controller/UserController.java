package com.example.rentacarportal.controller;

import com.example.rentacarportal.entity.Company;
import com.example.rentacarportal.entity.User;
import com.example.rentacarportal.message.MessageResponse;
import com.example.rentacarportal.service.CompanyService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/add")
    public MessageResponse addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @GetMapping("/getById")
    public User getUserById(@RequestParam Long id) {
        return userService.getUserById(id);
    }

    @GetMapping("/getByName")
    public User getUserByUsername(@RequestParam String userName){
        return userService.getUserByUsername(userName);
    }
}

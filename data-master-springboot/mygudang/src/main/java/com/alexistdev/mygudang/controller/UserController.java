package com.alexistdev.mygudang.controller;

import com.alexistdev.mygudang.entity.User;
import com.alexistdev.mygudang.service.Userservice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


import java.util.Optional;
@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private Userservice userservice;

    @PostMapping
    public User create(@RequestBody User user){
        return userservice.save(user);
    }

    @GetMapping
    public Iterable<User> findAll(){
        return userservice.findAll();
    }
}

package com.alexistdev.mygudang.controller;

import com.alexistdev.mygudang.entity.User;
import com.alexistdev.mygudang.service.Userservice;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


import java.util.Optional;
@RestController
public class UserController {
    private Userservice userservice;

    public UserController(Userservice userservice){
        this.userservice = userservice;
    }

    @GetMapping("/users")
    public User getUser(@RequestParam Integer id){
        Optional user = userservice.getUser(id);
        if(user.isPresent()){
            return (User) user.get();
        }
        return null;
    }
}

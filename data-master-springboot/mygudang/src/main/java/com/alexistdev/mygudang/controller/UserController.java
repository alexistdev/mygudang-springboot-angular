package com.alexistdev.mygudang.controller;

import com.alexistdev.mygudang.entity.User;
import com.alexistdev.mygudang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @Autowired
    private UserService userservice;

    @PostMapping
    public User create(@RequestBody User user){
        return userservice.save(user);
    }

    @GetMapping
    public Iterable<User> findAll(){
        return userservice.findAll();
    }

    @GetMapping("/{id}")
    public User findOne(@PathVariable("id") Long x){
        return userservice.findUser(x);
    }

    @DeleteMapping("/{id}")
    public void removeOne(@PathVariable("id") Long id){
        userservice.remove(id);
    }

    @PutMapping
    public User update(@RequestBody User user){
        return userservice.save(user);
    }
}

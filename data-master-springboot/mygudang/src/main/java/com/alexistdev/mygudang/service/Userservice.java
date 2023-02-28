package com.alexistdev.mygudang.service;

import com.alexistdev.mygudang.dto.UserDto;
import com.alexistdev.mygudang.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


import java.security.SecureRandom;
import java.util.Date;
import java.util.List;

@Service
@Transactional
public class Userservice {

    @Autowired
    private UserDto userDto;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());

    public User save(User user){
        user.setCreatedDate(new Date());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userDto.save(user);
    }

    public User findUser(Long id){
        return userDto.findById(id).get();
    }

    public Iterable<User> findAll(){
        return userDto.findAll();
    }

    public void remove(Long id){
        userDto.deleteById(id);
    }

    public List<User> findByName(String name){
        return userDto.findByNameContains(name);
    }
}

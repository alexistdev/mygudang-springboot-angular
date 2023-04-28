package com.alexistdev.mygudang.service.impl;

import com.alexistdev.mygudang.entity.User;
import com.alexistdev.mygudang.repository.UserRepository;
import com.alexistdev.mygudang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;



    @Override
    public User save(User users) throws Exception {
        User insertUser = new User();
        insertUser.setName(users.getName());
        insertUser.setEmail(users.getEmail());
        insertUser.setPassword(passwordEncoder.encode(users.getPassword()));
        insertUser.setPhone(users.getPhone());
        insertUser.setCreatedDate(new Date());
        return userRepository.save(insertUser);
    }

    @Override
    public User findByEmail(String email) throws Exception {
        return userRepository.findByEmailContains(email);
    }

    @Override
    public boolean authenticateLogin(String password1, String password2) throws Exception {
        return passwordEncoder.matches(password1, password2);
    }
}

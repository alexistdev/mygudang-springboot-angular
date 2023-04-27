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
        String password = passwordEncoder.encode(users.getPassword());
        insertUser.setPassword(password);
        insertUser.setPhone(users.getPhone());
        insertUser.setCreatedDate(new Date());
        return userRepository.save(insertUser);
    }

    @Override
    public User findByEmail(String email) throws Exception {
        return null;
    }
}

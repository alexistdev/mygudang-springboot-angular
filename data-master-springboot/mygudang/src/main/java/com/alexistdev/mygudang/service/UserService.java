package com.alexistdev.mygudang.service;

import com.alexistdev.mygudang.repository.UserRepository;
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
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());

    public User save(User user){
        user.setCreatedDate(new Date());
        user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public User findUser(Long id){
        return userRepository.findById(id).get();
    }

    public Iterable<User> findAll(){
        return userRepository.findAll();
    }

    public void remove(Long id){
        userRepository.deleteById(id);
    }

    public List<User> findByName(String name){
        return userRepository.findByNameContains(name);
    }
}

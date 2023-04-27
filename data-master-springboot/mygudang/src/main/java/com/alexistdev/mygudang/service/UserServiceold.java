package com.alexistdev.mygudang.service;

import com.alexistdev.mygudang.repository.UserRepository;
import com.alexistdev.mygudang.entity.User;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
@Transactional
public class UserServiceold {
//
//    @Autowired
//    private UserRepository userRepository;
//
////    public static BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder(10, new SecureRandom());
//    @Autowired
//    private PasswordEncoder passwordEncoder;
//
//
//
////    public User save(User user) throws Exception{
////        user.setCreatedDate(new Date());
////        user.setPassword(passwordEncoder.encode(user.getPassword()));
////        return userRepository.save(user);
////    }
//
//    public User findUser(Long id){
//        return userRepository.findById(id).get();
//    }
//
//    public Iterable<User> findAll(){
//        return userRepository.findAll();
//    }
//
//    public void remove(Long id){
//        userRepository.deleteById(id);
//    }
//
//    public List<User> findByName(String name){
//        return userRepository.findByNameContains(name);
//    }
//
//    public User findByEmail(String email){ return userRepository.findByEmailContains(email);}
}

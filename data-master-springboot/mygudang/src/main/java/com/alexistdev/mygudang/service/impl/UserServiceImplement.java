package com.alexistdev.mygudang.service.impl;

import com.alexistdev.mygudang.entity.User;
import com.alexistdev.mygudang.repository.RoleRepository;
import com.alexistdev.mygudang.repository.UserRepository;
import com.alexistdev.mygudang.service.RoleService;
import com.alexistdev.mygudang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class UserServiceImplement implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    RoleService roleService;

    @Override
    public User save(User users) throws Exception {
        Date now = new Date();

        User insertUser = User.builder()
                .name(users.getName())
                .email(users.getEmail())
                .password(passwordEncoder.encode(users.getPassword()))
                .phone(users.getPhone())
                .createdAt(now)
                .updatedAt(now)
                .role(users.getRole())
                .isActive(1)
                .createdBy("System")
                .modifiedBy("System")
                .build();

        return userRepository.save(insertUser);
    }

    @Override
    public User getById(String id) throws Exception {
        return userRepository.findById(id).orElse(null);
    }

    @Override
    public User findByEmail(String email) throws Exception {
        return userRepository.findByEmailContains(email);
    }

    @Override
    public boolean authenticateLogin(String password1, String password2) throws Exception {
        return passwordEncoder.matches(password1, password2);
    }

    @Override
    public List<User> getAll() throws Exception {
        List<User> userList = new ArrayList<>();
        Iterable<User> iterable = userRepository.findAll();
        iterable.forEach(userList::add);
        return userList;
    }
}

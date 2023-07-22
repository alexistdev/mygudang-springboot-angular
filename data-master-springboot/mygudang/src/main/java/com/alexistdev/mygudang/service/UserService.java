package com.alexistdev.mygudang.service;

import com.alexistdev.mygudang.entity.User;

import java.util.List;

public interface UserService {
    User save(User user) throws Exception;

    User getById(String id) throws Exception;

    List<User> getAll() throws Exception;

    User findByEmail(String email) throws Exception;

    boolean authenticateLogin(String password1, String password2) throws Exception;
}

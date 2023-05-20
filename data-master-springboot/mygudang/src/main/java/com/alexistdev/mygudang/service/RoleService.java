package com.alexistdev.mygudang.service;

import com.alexistdev.mygudang.entity.Role;

import java.util.List;

public interface RoleService {
    Role save(Role role) throws Exception;

    Role getById(String id) throws Exception;

    List<Role> getAll() throws Exception;
}

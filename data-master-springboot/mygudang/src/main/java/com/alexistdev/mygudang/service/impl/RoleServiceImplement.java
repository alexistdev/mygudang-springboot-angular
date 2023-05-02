package com.alexistdev.mygudang.service.impl;

import com.alexistdev.mygudang.entity.Role;
import com.alexistdev.mygudang.repository.RoleRepository;
import com.alexistdev.mygudang.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
@Repository
public class RoleServiceImplement implements RoleService {

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role save(Role role) throws Exception
    {
        Date now = new Date();
        Role insertRole = new Role();
        insertRole.setName(role.getName());
        insertRole.setLevel(role.getLevel());
        insertRole.setCreatedAt(now);
        insertRole.setUpdatedAt(now);
        return roleRepository.save(insertRole);
    }

    @Override
    public Role getById(String id) throws Exception {
        return roleRepository.findById(Long.parseLong(id)).orElse(null);
    }
}

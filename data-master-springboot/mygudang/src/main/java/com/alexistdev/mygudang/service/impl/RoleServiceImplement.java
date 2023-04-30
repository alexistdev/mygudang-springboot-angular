package com.alexistdev.mygudang.service.impl;

import com.alexistdev.mygudang.entity.Role;
import com.alexistdev.mygudang.service.RoleService;
import org.springframework.stereotype.Repository;

import java.util.Date;
@Repository
public class RoleServiceImplement implements RoleService {

    @Override
    public Role save(Role role) throws Exception
    {
        Date now = new Date();
        Role insertRole = new Role();
        insertRole.setName(role.getName());
        insertRole.setLevel(role.getLevel());
        insertRole.setCreatedAt(now);
        insertRole.setUpdatedAt(now);
        return insertRole;
    }
}

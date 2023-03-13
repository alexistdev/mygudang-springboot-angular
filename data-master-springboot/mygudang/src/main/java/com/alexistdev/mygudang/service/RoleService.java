package com.alexistdev.mygudang.service;

import com.alexistdev.mygudang.entity.Role;
import com.alexistdev.mygudang.repository.RoleRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
@Transactional
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    private final Date date = new Date();

    public Role save(Role role){
        role.setCreatedAt(date);
        role.setUpdatedAt(date);
        return roleRepository.save(role);
    }
}

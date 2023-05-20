package com.alexistdev.mygudang.service.impl;

import com.alexistdev.mygudang.dto.PermissionDTO;
import com.alexistdev.mygudang.entity.Permission;
import com.alexistdev.mygudang.entity.Role;
import com.alexistdev.mygudang.repository.PermissionRepository;
import com.alexistdev.mygudang.repository.RoleRepository;
import com.alexistdev.mygudang.service.PermissionService;
import com.alexistdev.mygudang.service.RoleService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import java.util.Date;

@Repository
public class PermissionServiceImplement implements PermissionService {

    @Autowired
    PermissionRepository permissionRepository;

    @Autowired
    RoleService roleService;

    @Lazy
    @Autowired
    private ModelMapper modelMapper;

    public Permission save(Permission permission) throws Exception
    {
        Date now = new Date();
//        Role role = roleService.getById(String.valueOf(permission.getRole().getId()));
        Permission insertPermission = new Permission();
        insertPermission.setRole(permission.getRole());
        insertPermission.setSlug(permission.getSlug());
        insertPermission.setUpdatedAt(now);
        insertPermission.setCreatedAt(now);
        return permissionRepository.save(insertPermission);
    }

    private Permission convertDTO(PermissionDTO permissionDTO) throws Exception {
        Permission permission = modelMapper.map(permissionDTO, Permission.class);
        return permission;
    }
}

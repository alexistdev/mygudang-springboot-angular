package com.alexistdev.mygudang.service.impl;

import com.alexistdev.mygudang.dto.PermissionDTO;
import com.alexistdev.mygudang.entity.Permission;
import com.alexistdev.mygudang.repository.PermissionRepository;
import com.alexistdev.mygudang.service.PermissionService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Repository;
import java.util.Date;

@Repository
public class PermissionServiceImplement implements PermissionService {

    @Autowired
    PermissionRepository permissionRepository;

    @Lazy
    @Autowired
    private ModelMapper modelMapper;

    public Permission save(PermissionDTO permission) throws Exception
    {
        Date now = new Date();
        Permission convertDTO = this.convertDTO(permission);
        Permission insertPermission = new Permission();
        insertPermission.setRoleId(convertDTO.getRoleId());
        insertPermission.setSlug(convertDTO.getSlug());
        insertPermission.setUpdatedAt(now);
        insertPermission.setCreatedAt(now);
        return permissionRepository.save(insertPermission);
    }

    private Permission convertDTO(PermissionDTO permissionDTO) throws Exception {
        Permission permission = modelMapper.map(permissionDTO, Permission.class);
        return permission;
    }
}

package com.alexistdev.mygudang.service.impl;

import com.alexistdev.mygudang.entity.Permission;
import com.alexistdev.mygudang.repository.PermissionRepository;
import com.alexistdev.mygudang.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Date;

@Repository
public class PermissionServiceImplement implements PermissionService {

    @Autowired
    PermissionRepository permissionRepository;

    public Permission save(Permission permission) throws Exception
    {
        Date now = new Date();
        Permission insertPermission = new Permission();
        insertPermission.setRoleId(permission.getRoleId());
        insertPermission.setSlug(permission.getSlug());
        insertPermission.setUpdatedAt(now);
        insertPermission.setCreatedAt(now);
        return permissionRepository.save(insertPermission);
    }
}

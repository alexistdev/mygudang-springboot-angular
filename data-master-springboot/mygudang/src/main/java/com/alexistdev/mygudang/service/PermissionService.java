package com.alexistdev.mygudang.service;

import com.alexistdev.mygudang.dto.PermissionDTO;
import com.alexistdev.mygudang.entity.Permission;

public interface PermissionService {
    Permission save(PermissionDTO permission) throws Exception;
}

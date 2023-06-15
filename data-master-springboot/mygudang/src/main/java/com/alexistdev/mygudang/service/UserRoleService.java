package com.alexistdev.mygudang.service;

import com.alexistdev.mygudang.dto.UserRoleDTO;
import com.alexistdev.mygudang.entity.UserRole;

public interface UserRoleService {

    UserRole save(UserRoleDTO userRoleDTO) throws Exception;

    UserRole getByUserId(String userId) throws Exception;

}

package com.alexistdev.mygudang.service;

import com.alexistdev.mygudang.dto.UserRoleDTO;
import com.alexistdev.mygudang.entity.UserRole;

import java.util.List;

public interface UserRoleService {

    UserRole save(UserRoleDTO userRoleDTO) throws Exception;

    List<UserRole> getByUserId(String userId) throws Exception;

}

package com.alexistdev.mygudang.service;

import com.alexistdev.mygudang.dto.RoleMenuDTO;
import com.alexistdev.mygudang.entity.RoleMenu;

import java.util.List;

public interface RoleMenuService {

    RoleMenu save(RoleMenuDTO roleMenuDTO) throws Exception;

    List<RoleMenu> getByRoleId(String roleId) throws Exception;
}

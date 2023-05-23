package com.alexistdev.mygudang.service;

import com.alexistdev.mygudang.dto.RoleMenuDTO;
import com.alexistdev.mygudang.entity.RoleMenu;

public interface RoleMenuService {

    RoleMenu save(RoleMenuDTO roleMenuDTO) throws Exception;
}

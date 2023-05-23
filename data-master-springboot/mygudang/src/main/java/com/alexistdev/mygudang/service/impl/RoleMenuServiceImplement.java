package com.alexistdev.mygudang.service.impl;

import com.alexistdev.mygudang.dto.RoleMenuDTO;
import com.alexistdev.mygudang.entity.RoleMenu;
import com.alexistdev.mygudang.repository.RoleMenuRepository;
import com.alexistdev.mygudang.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;

@Repository
public class RoleMenuServiceImplement implements RoleMenuService {

    @Autowired
    private RoleMenuRepository roleMenuRepository;

    @Override
    public RoleMenu save(RoleMenuDTO roleMenuDTO) throws Exception {
        Date now = new Date();
        RoleMenu insertRoleMenu = new RoleMenu();
        insertRoleMenu.setRole(roleMenuDTO.getRole());
        insertRoleMenu.setMenu(roleMenuDTO.getMenu());
        insertRoleMenu.setCreatedAt(now);
        insertRoleMenu.setUpdatedAt(now);
        insertRoleMenu.setCreatedBy(roleMenuDTO.getCreatedBy());
        insertRoleMenu.setModifiedBy(roleMenuDTO.getModifiedBy());
        return roleMenuRepository.save(insertRoleMenu);
    }
}

package com.alexistdev.mygudang.service.impl;

import com.alexistdev.mygudang.dto.RoleMenuDTO;
import com.alexistdev.mygudang.entity.RoleMenu;
import com.alexistdev.mygudang.repository.RoleMenuRepository;
import com.alexistdev.mygudang.service.RoleMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public class RoleMenuServiceImplement implements RoleMenuService {

    @Autowired
    private RoleMenuRepository roleMenuRepository;

    @Override
    public RoleMenu save(RoleMenuDTO roleMenuDTO) throws Exception {
        Date now = new Date();

        RoleMenu insertRoleMenu = RoleMenu.builder()
                        .role(roleMenuDTO.getRole())
                        .menu(roleMenuDTO.getMenu())
                        .createdAt(now)
                        .updatedAt(now)
                        .createdBy(roleMenuDTO.getCreatedBy())
                        .modifiedBy(roleMenuDTO.getModifiedBy())
                        .build();

        return roleMenuRepository.save(insertRoleMenu);
    }

    @Override
    public List<RoleMenu> getByRoleId(String roleId) throws Exception {
        return roleMenuRepository.findByRoleId(roleId);
    }
}

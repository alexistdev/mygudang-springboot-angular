package com.alexistdev.mygudang.service;

import com.alexistdev.mygudang.dto.MenuDTO;
import com.alexistdev.mygudang.dto.RoleMenuDTO;
import com.alexistdev.mygudang.entity.Menu;
import com.alexistdev.mygudang.entity.Role;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

@SpringBootTest
public class RoleMenuServiceTest {

    @Autowired
    private RoleMenuService roleMenuService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private MenuService menuService;

    @Test
    @Disabled
    public void insertRoleMenuSuccessTest() throws Exception {
//        Role insertRole = new Role();
//        insertRole.setName("Administrator");
//        insertRole.setDescription("Halaman Administrator");
//        insertRole.setCreatedBy("Testing");
//        insertRole.setModifiedBy("Testing");
//        Role resultRole = roleService.save(insertRole);
//
//        MenuDTO insertMenu = new MenuDTO();
//        insertMenu.setLabel("dashboard");
//        insertMenu.setDescription("halaman dashboard");
//        insertMenu.setUrl("/dashboard");
//        insertMenu.setLabel("dashboard");
//        insertMenu.setCreatedBy("Testing");
//        insertMenu.setModifiedBy("Testing");
//        Menu resultMenu = menuService.save(insertMenu);
//
//        RoleMenuDTO roleMenuDTO = new RoleMenuDTO();
//        roleMenuDTO.setRole(resultRole);
//        roleMenuDTO.setMenu(resultMenu);
//        roleMenuDTO.setCreatedBy("Testing");
//        roleMenuDTO.setModifiedBy("Testing");
//        Assertions.assertNotNull(roleMenuService.save(roleMenuDTO));

    }

    @Test
    public void insertMenuFailRoleEmpty() {

            Menu insertMenu = new Menu();
            insertMenu.setLabel("dashboard");
            insertMenu.setDescription("halaman dashboard");
            insertMenu.setUrl("/dashboard");
            insertMenu.setLabel("dashboard");
            insertMenu.setCreatedBy("Testing");
            insertMenu.setModifiedBy("Testing");

            RoleMenuDTO roleMenuDTO = new RoleMenuDTO();
            roleMenuDTO.setCreatedBy("Testing");
            roleMenuDTO.setModifiedBy("Testing");
            Assertions.assertThrows(DataIntegrityViolationException.class, () -> roleMenuService.save(roleMenuDTO));
    }
}

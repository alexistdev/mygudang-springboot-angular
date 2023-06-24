package com.alexistdev.mygudang.service;

import com.alexistdev.mygudang.dto.UserRoleDTO;
import com.alexistdev.mygudang.entity.Role;
import com.alexistdev.mygudang.entity.User;
import com.alexistdev.mygudang.service.impl.UserServiceImplement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.context.annotation.Bean;

import java.util.Date;


@SpringBootTest
//@ContextConfiguration(classes = {RoleService.class,UserService.class})
public class UserRoleServiceTest {



    @Autowired
    private UserRoleService userRoleService;
//
    @Autowired
    private RoleService roleService;
    //
    @Autowired
    private UserService userService;

    @Test
    public void insertUserRoleSuccessTest() throws Exception {
        Role insertRole = new Role();
        insertRole.setName("Administrator");
        insertRole.setDescription("Halaman Administrator");
        insertRole.setCreatedBy("Testing");
        insertRole.setModifiedBy("Testing");
        Role resultRole = roleService.save(insertRole);

        User insertUser = new User();
        insertUser.setPhone("0823123123");
        insertUser.setEmail("hendra@gmail.com");
        insertUser.setName("hendra");
        insertUser.setPassword("1234");
        insertUser.setIsActive(1);
        User resultUser = userService.save(insertUser);

        UserRoleDTO insertUserRoleDTO = new UserRoleDTO();
        insertUserRoleDTO.setRole(resultRole);
        insertUserRoleDTO.setUser(resultUser);
        insertUserRoleDTO.setCreatedBy("System");
        insertUserRoleDTO.setModifiedBy("System");
        Assertions.assertNotNull(userRoleService.save(insertUserRoleDTO));
    }


}

package com.alexistdev.mygudang.service;

import com.alexistdev.mygudang.dao.RoleDAO;
import com.alexistdev.mygudang.entity.Role;
import com.alexistdev.mygudang.exception.DuplicatException;
import com.alexistdev.mygudang.repository.RoleRepository;
import com.alexistdev.mygudang.service.impl.RoleServiceImplement;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Date;
import java.util.Optional;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    private RoleServiceImplement roleService;

    @Autowired
    private TestEntityManager testEntityManager;


    private RoleDAO roleDAO;

    private Role role;


    @BeforeEach
    public void setup() {
        roleService = new RoleServiceImplement(roleRepository);
        roleDAO = RoleDAO.builder()
                .createdBy("system test")
                .modifiedBy("system test")
                .name("test")
                .description("test description")
                .build();
    }

    @DisplayName("Testing for Role Service")
    @Test
    public void when_save_role_should_return_role_test() throws Exception {
        Role created = roleService.save(roleDAO);
        Assertions.assertEquals(created.getName(), roleDAO.getName());
    }

    @DisplayName("Duplicate Role")
    @Test
    public void duplicate_role_name_throw_errors() throws DuplicatException {
        Role role = Role.builder()
                .name("test")
                .description("test description")
                .build();
        when(roleRepository.findByName(anyString())).thenReturn(Optional.of(role));
        Assertions.assertThrows(RuntimeException.class, () -> {
            roleService.save(roleDAO);
        });
    }


    private Role generateEntity() {
        Date now = new Date();
        Role role = new Role();
        role.setStatus("1");
        role.setDescription("Ini testing");
        role.setName("testing1");
        role.setCreatedAt(now);
        role.setUpdatedAt(now);
        role.setCreatedBy("System");
        role.setModifiedBy("System");

        role = testEntityManager.persist(role);
        testEntityManager.flush();

        return role;
    }
}

package com.alexistdev.mygudang.service;

import com.alexistdev.mygudang.dao.RoleDAO;
import com.alexistdev.mygudang.entity.Role;
import com.alexistdev.mygudang.exception.DuplicatException;
import com.alexistdev.mygudang.repository.RoleRepository;
import com.alexistdev.mygudang.service.impl.RoleServiceImplement;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    private RoleServiceImplement roleService;

    private RoleDAO roleDAO;


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
    public void duplicate_role_name_throw_errors(){
        Role role = Role.builder().name("test").description("test description").build();
        when(roleRepository.findByName(anyString())).thenReturn(Optional.of(role));
        Assertions.assertThrows(DuplicatException.class, () -> {
            roleService.save(roleDAO);
        });
    }

    @DisplayName("BadFormat")
    @Disabled
    @Test
    public void empty_name_throw_error(){
        when(roleRepository.save(any(Role.class))).thenReturn(null);
        roleDAO.setName(null);
        Assertions.assertThrows(Exception.class, () -> {
            roleService.save(roleDAO);
        });
    }
}

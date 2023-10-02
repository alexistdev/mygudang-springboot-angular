package com.alexistdev.mygudang.service;

import com.alexistdev.mygudang.dao.RoleDAO;
import com.alexistdev.mygudang.dto.BasicInfo;
import com.alexistdev.mygudang.entity.Role;
import com.alexistdev.mygudang.exception.DuplicatException;
import com.alexistdev.mygudang.repository.RoleRepository;
import com.alexistdev.mygudang.service.impl.RoleServiceImplement;
import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import java.util.Optional;
import java.util.Set;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    private RoleServiceImplement roleService;

    private RoleDAO roleDAO;

    private static Validator validator;

    @BeforeEach
    public void setup() {
        validator = Validation.buildDefaultValidatorFactory()
                .getValidator();
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
        Assertions.assertThrows(RuntimeException.class, () -> {
            roleService.save(roleDAO);
        });
    }

    @DisplayName("BadFormat")
    @Test
    public void empty_name_throw_error(){
        roleDAO.setName(null);
        Set<ConstraintViolation<RoleDAO>> violations = validator.validate(roleDAO, BasicInfo.class);
        assertThat(violations.size()).isEqualTo(1);
        violations.forEach(action -> {
            assertThat(action.getMessage()).isEqualTo("Name should not be empty");
            assertThat(action.getPropertyPath()
                    .toString()).isEqualTo("name");
        });
    }
}

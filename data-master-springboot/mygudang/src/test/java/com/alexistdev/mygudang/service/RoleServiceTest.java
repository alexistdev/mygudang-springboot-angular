package com.alexistdev.mygudang.service;

import com.alexistdev.mygudang.dao.RoleDAO;
import com.alexistdev.mygudang.entity.Role;
import com.alexistdev.mygudang.repository.RoleRepository;
import com.alexistdev.mygudang.service.impl.RoleServiceImplement;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.*;
import java.util.Optional;

@ExtendWith(MockitoExtension.class)
public class RoleServiceTest {

    @Mock
    private RoleRepository roleRepository;

    @InjectMocks
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
        Assertions.assertThrows(RuntimeException.class, () -> {
            roleService.save(roleDAO);
        });
    }

    @DisplayName("Update service Test")
    @Test
    public void update_role_test(){
        Role role = new Role();
        role.setName("testing");
        role.setId("3eb547ec-1b18-4e1d-acf9-1239d37fa31c");
        lenient().when(roleRepository.findById(role.getId())).thenReturn(Optional.of(role));
        Optional<Role> updatedRole = roleService.update(roleDAO,role.getId());
        Assertions.assertNotNull(updatedRole);
        assert updatedRole.orElse(null) != null;
        Assertions.assertSame(updatedRole.orElse(null).getName(),roleDAO.getName());
    }
    @Test
    public void find_by_id_should_return_role() throws Exception{
        Role role = Role.builder().name("test").description("test description").build();
        role.setId("3eb547ec-1b18-4e1d-acf9-1239d37fa31c");
        lenient().when(roleRepository.findById(role.getId())).thenReturn(Optional.of(role));
        Role getRole = roleService.getById("3eb547ec-1b18-4e1d-acf9-1239d37fa31c");
        Assertions.assertSame(role.getName(),getRole.getName());
    }

}

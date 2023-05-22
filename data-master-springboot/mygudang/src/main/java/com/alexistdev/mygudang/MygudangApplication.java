package com.alexistdev.mygudang;

import com.alexistdev.mygudang.dto.MenuDTO;
import com.alexistdev.mygudang.entity.Permission;
import com.alexistdev.mygudang.entity.Role;
import com.alexistdev.mygudang.entity.User;
import com.alexistdev.mygudang.service.MenuService;
import com.alexistdev.mygudang.service.PermissionService;
import com.alexistdev.mygudang.service.RoleService;
import com.alexistdev.mygudang.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;

@SpringBootApplication
public class MygudangApplication {

    public static void main(String[] args) {
        SpringApplication.run(MygudangApplication.class, args);
    }

    @Autowired
    UserService userService;

    @Autowired
    RoleService roleService;

    @Autowired
    PermissionService permissionService;

    @Autowired
    MenuService menuService;

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Bean
    public PasswordEncoder encoder() {
        return new BCryptPasswordEncoder();
    }

    @Bean
    CommandLineRunner seedRole() {
        return args -> {
            HashMap<String,String> names = new HashMap<>();
            names.put("Superadmin","Super Admin");
            names.put("Admin","Administrator");
            names.put("Admin Gudang","Admin Gudang Input Stock");
            names.put("Admin PO","Admin untuk membuat PO");
            for (Map.Entry<String, String> set : names.entrySet()) {
                Role role = new Role();
                role.setName(set.getKey());
                role.setDescription(set.getValue());
                role.setCreatedBy("System");
                role.setModifiedBy("System");
                roleService.save(role);
            }
        };
    }

    @Bean
    CommandLineRunner seedMenu() {
        return args -> {
            MenuDTO insertMenu = new MenuDTO();
            insertMenu.setMenuCode("dashboard");
            insertMenu.setUrl("/dashboard");
            insertMenu.setLabel("fa-dashboard");
            insertMenu.setDescription("Halaman dashboard");
            insertMenu.setCreatedBy("System");
            insertMenu.setModifiedBy("System");
            menuService.save(insertMenu);
        };
    }

    @Bean
    CommandLineRunner seedUser() {
        return args -> {
            List<Role> roles = roleService.getAll();
            User user = new User();
            user.setName("Alex");
            user.setPassword("1234");
            user.setIsActive(1);
            user.setPhone("082371408678");
            user.setEmail("alexistdev@gmail.com");
            user.setRole(roles.get(1));
            userService.save(user);
        };
    }

    @Bean
    CommandLineRunner seedPermission() {
        return args -> {
            List<Role> roles = roleService.getAll();
            Permission permission1 = new Permission();
            permission1.setRole(roles.get(0));
            permission1.setSlug("/dashboard");
            permissionService.save(permission1);
        };
    }
}

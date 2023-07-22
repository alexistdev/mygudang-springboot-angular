package com.alexistdev.mygudang;

import com.alexistdev.mygudang.dto.MenuDTO;
import com.alexistdev.mygudang.dto.RoleMenuDTO;
import com.alexistdev.mygudang.entity.Menu;
import com.alexistdev.mygudang.entity.Permission;
import com.alexistdev.mygudang.entity.Role;
import com.alexistdev.mygudang.entity.User;
import com.alexistdev.mygudang.service.*;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.*;
import java.util.logging.Logger;

@SpringBootApplication
public class MygudangApplication {

    public static void main(String[] args) {
        SpringApplication.run(MygudangApplication.class, args);
    }

    static Logger logger = Logger.getLogger(MygudangApplication.class.getName());

    @Autowired
    private UserService userService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private PermissionService permissionService;

    @Autowired
    private MenuService menuService;

    @Autowired
    private RoleMenuService roleMenuService;


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

//    @Bean
//    CommandLineRunner seedMenu() {
//        return args -> {
//            MenuDTO insertMenu = new MenuDTO();
//            insertMenu.setName("Dashboard");
//            insertMenu.setUrl("/dashboard");
//            insertMenu.setLabel("bx bx-home-alt");
//            insertMenu.setDescription("Halaman dashboard");
//            insertMenu.setOrder(1);
//            insertMenu.setCreatedBy("System");
//            insertMenu.setModifiedBy("System");
////            menuService.save(insertMenu);
//
//            MenuDTO insertMenu2 = new MenuDTO();
//            insertMenu2.setName("Transaksi");
//            insertMenu2.setUrl("/transaction");
//            insertMenu2.setLabel("bx bx-data");
//            insertMenu2.setDescription("Halaman transaksi");
//            insertMenu2.setOrder(2);
//            insertMenu2.setCreatedBy("System");
//            insertMenu2.setModifiedBy("System");
////            menuService.save(insertMenu2);
//
//            MenuDTO insertMenu3 = new MenuDTO();
//            insertMenu3.setName("Data");
//            insertMenu3.setUrl("/data");
//            insertMenu3.setLabel("bx bx-data");
//            insertMenu3.setDescription("Halaman data");
//            insertMenu3.setOrder(3);
//            insertMenu3.setCreatedBy("System");
//            insertMenu3.setModifiedBy("System");
////            menuService.save(insertMenu3);
//
//
//        };
//    }

//    @Bean
//    CommandLineRunner seedUser() {
//        return args -> {
//            User user = new User();
//            user.setName("Alex");
//            user.setPassword("1234");
//            user.setIsActive(1);
//            user.setPhone("082371408678");
//            user.setEmail("alexistdev@gmail.com");
////            userService.save(user);
//        };
//    }

//    @Bean
//    CommandLineRunner seedRoleMenu() {
//        return args -> {
//            List<Role> roles = roleService.getAll();
//            List<Menu> menus = menuService.getAll();
//            RoleMenuDTO roleMenuDTO = new RoleMenuDTO();
//            roleMenuDTO.setRole(roles.get(0));
//            roleMenuDTO.setMenu(menus.get(0));
//            roleMenuDTO.setCreatedBy("System");
//            roleMenuDTO.setModifiedBy("System");
////            roleMenuService.save(roleMenuDTO);
//
//            RoleMenuDTO roleMenuDTO2 = new RoleMenuDTO();
//            roleMenuDTO2.setRole(roles.get(0));
//            roleMenuDTO2.setMenu(menus.get(1));
//            roleMenuDTO2.setCreatedBy("System");
//            roleMenuDTO2.setModifiedBy("System");
////            roleMenuService.save(roleMenuDTO2);
//        };
//    }

//    @Bean
//    CommandLineRunner seedPermission() {
//        return args -> {
//            List<Role> roles = roleService.getAll();
//            Permission permission1 = new Permission();
//            permission1.setRole(roles.get(0));
//            permission1.setSlug("/dashboard");
////            logger.log(Level.WARNING, "ini testing logger");
//            permissionService.save(permission1);
//        };
//    }
}

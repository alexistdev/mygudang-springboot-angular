package com.alexistdev.mygudang.service;

import com.alexistdev.mygudang.dto.MenuDTO;

import com.alexistdev.mygudang.entity.Menu;
import com.alexistdev.mygudang.repository.MenuRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.SQLException;
import java.util.Date;
import java.util.function.BooleanSupplier;

@SpringBootTest
public class MenuServiceTest {

    @Autowired
    private MenuService menuService;

    @Test
    public void insertMenuSuccessTest()  throws Exception{
        MenuDTO insertMenu = new MenuDTO();
        insertMenu.setMenuCode("dashboard");
        insertMenu.setUrl("/dashboard");
        insertMenu.setLabel("fa-dashboard");
        insertMenu.setDescription("Halaman dashboard");
        insertMenu.setCreatedBy("System");
        insertMenu.setModifiedBy("System");
        Assertions.assertNotNull(menuService.save(insertMenu));
    }

    @Test
    public void insertMenuFailTest(){
//        MenuDTO insertMenu = new MenuDTO();
//        insertMenu.setMenuCode("dashboard");
//        menuService.save(insertMenu);
//        Assertions.assertThrows(SQLException.class);
    }
}

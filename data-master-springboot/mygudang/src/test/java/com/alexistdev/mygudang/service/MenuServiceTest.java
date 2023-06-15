package com.alexistdev.mygudang.service;

import com.alexistdev.mygudang.dto.MenuDTO;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;

@SpringBootTest
public class MenuServiceTest {

    @Autowired
    private MenuService menuService;

    @Test
    public void insertMenuSuccessTest()  throws Exception{
        MenuDTO insertMenu = new MenuDTO();
        insertMenu.setLabel("dashboard");
        insertMenu.setUrl("/dashboard");
        insertMenu.setLabel("fa-dashboard");
        insertMenu.setDescription("Halaman dashboard");
        insertMenu.setCreatedBy("System");
        insertMenu.setModifiedBy("System");
        Assertions.assertNotNull(menuService.save(insertMenu));
    }

    @Test
    public void insertMenuFailDataNullTest(){
        MenuDTO insertMenu = new MenuDTO();
        insertMenu.setLabel("dashboard");
        Assertions.assertThrows(DataIntegrityViolationException.class, ()-> menuService.save(insertMenu));
    }
}

package com.alexistdev.mygudang.service.impl;

import com.alexistdev.mygudang.dto.MenuDTO;
import com.alexistdev.mygudang.entity.Menu;
import com.alexistdev.mygudang.entity.Role;
import com.alexistdev.mygudang.repository.MenuRepository;
import com.alexistdev.mygudang.request.MenuRequest;
import com.alexistdev.mygudang.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class MenuServiceImplement implements MenuService {
    @Autowired
    private MenuRepository menuRepository;


    @Override
    public Menu save(MenuRequest menu) throws Exception{
        Date now = new Date();
        Menu insertMenu = Menu.builder()
                .name(menu.getName())
                .description(menu.getDescription())
                .url(menu.getUrl())
                .label(menu.getLabel())
                .order(menu.getOrder())
                .createdAt(now)
                .updatedAt(now)
                .createdBy(menu.getCreatedBy())
                .modifiedBy(menu.getModifiedBy())
                .build();
        return menuRepository.save(insertMenu);
    }

    @Override
    public List<Menu> getAll() throws Exception {
        List<Menu> menuList = new ArrayList<>();
        Iterable<Menu> iterable = menuRepository.findAll();
        iterable.forEach(menuList::add);
        return menuList;
    }
}

package com.alexistdev.mygudang.service;

import com.alexistdev.mygudang.dto.MenuDTO;
import com.alexistdev.mygudang.entity.Menu;
import com.alexistdev.mygudang.entity.Role;
import com.alexistdev.mygudang.request.MenuRequest;

import java.util.List;

public interface MenuService {
    Menu save(MenuRequest menu) throws Exception;

    List<Menu> getAll() throws Exception;
}

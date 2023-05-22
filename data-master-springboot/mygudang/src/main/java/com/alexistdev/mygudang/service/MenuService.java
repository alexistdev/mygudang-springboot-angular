package com.alexistdev.mygudang.service;

import com.alexistdev.mygudang.dto.MenuDTO;
import com.alexistdev.mygudang.entity.Menu;

public interface MenuService {
    Menu save(MenuDTO menu) throws Exception;
}

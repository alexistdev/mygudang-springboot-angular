package com.alexistdev.mygudang.controller;

import com.alexistdev.mygudang.dto.MenuDTO;
import com.alexistdev.mygudang.dto.ResponseData;
import com.alexistdev.mygudang.entity.Menu;
import com.alexistdev.mygudang.entity.Permission;
import com.alexistdev.mygudang.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping
    public ResponseEntity<ResponseData> create(@RequestBody MenuDTO menu) throws Exception{
        ResponseData<Menu> responseData = new ResponseData<>();
        responseData.setStatus(true);
        Menu result = menuService.save(menu);
        responseData.setPayload(result);
        return ResponseEntity.ok(responseData);
    }

}

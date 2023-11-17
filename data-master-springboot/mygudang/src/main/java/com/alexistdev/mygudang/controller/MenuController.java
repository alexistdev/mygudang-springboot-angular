package com.alexistdev.mygudang.controller;

import com.alexistdev.mygudang.dto.MenuDTO;
import com.alexistdev.mygudang.dto.ResponseData;
import com.alexistdev.mygudang.entity.Menu;
import com.alexistdev.mygudang.entity.Role;
import com.alexistdev.mygudang.request.MenuRequest;
import com.alexistdev.mygudang.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/menu")
public class MenuController {

    @Autowired
    private MenuService menuService;

    @PostMapping
    public ResponseEntity<?> create(@RequestBody MenuRequest menu){
        ResponseData<Menu> responseData = new ResponseData<>();
        responseData.setStatus(false);
        try {
            Menu result = menuService.save(menu);
            responseData.setStatus(true);
            responseData.setData(result);
            return ResponseEntity.ok(responseData);
        }catch (Exception e){
            responseData.setMessages(e.getMessage());
            return new ResponseEntity<ResponseData<?>>(responseData, HttpStatus.BAD_REQUEST);
        }
    }

}

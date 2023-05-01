package com.alexistdev.mygudang.controller;

import com.alexistdev.mygudang.entity.Role;
import com.alexistdev.mygudang.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/roles")
public class RoleController {
    @Autowired
    private RoleService roleService;

    @PostMapping
    public Role create(@RequestBody Role role) throws Exception{
        return roleService.save(role);
    }
}

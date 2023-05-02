package com.alexistdev.mygudang.controller;

import com.alexistdev.mygudang.dto.PermissionDTO;
import com.alexistdev.mygudang.dto.ResponseData;
import com.alexistdev.mygudang.entity.Permission;
import com.alexistdev.mygudang.entity.Role;
import com.alexistdev.mygudang.entity.User;
import com.alexistdev.mygudang.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/permission")
public class PermissionController {

    @Autowired
    PermissionService permissionService;

    @PostMapping
    public ResponseEntity<ResponseData> create(@RequestBody Permission permission) throws Exception{
        if(permission.getSlug().isEmpty()){
            throw new Exception();
        }
        ResponseData<Permission> responseData = new ResponseData<>();
        responseData.setStatus(true);
        Permission permissionDTO = permissionService.save(permission);
        responseData.setPayload(permissionDTO);
        return ResponseEntity.ok(responseData);
    }
}

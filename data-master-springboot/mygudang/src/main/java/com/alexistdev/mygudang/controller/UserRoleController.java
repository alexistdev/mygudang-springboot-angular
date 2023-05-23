package com.alexistdev.mygudang.controller;

import com.alexistdev.mygudang.dto.ResponseData;
import com.alexistdev.mygudang.dto.UserRoleDAO;
import com.alexistdev.mygudang.dto.UserRoleDTO;
import com.alexistdev.mygudang.entity.Role;
import com.alexistdev.mygudang.entity.User;
import com.alexistdev.mygudang.entity.UserRole;
import com.alexistdev.mygudang.service.RoleService;
import com.alexistdev.mygudang.service.UserRoleService;
import com.alexistdev.mygudang.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/usersroles")
public class UserRoleController {
    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleService roleService;

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<ResponseData> create(@Valid @RequestBody UserRoleDAO DAO) throws Exception{
        ResponseData<User> responseData = new ResponseData<>();
        List<String> message = new ArrayList<>();
        message.add("Data berhasil didapatkan");
        responseData.setStatus(true);

//        Role role = roleService.getById(DAO.getRoleId());
        User user = userService.getById(DAO.getUserId());
        responseData.setPayload(user);
//        if(role == null){
//            return new ResponseEntity<ResponseData>(responseData, HttpStatus.BAD_REQUEST);
//        }
//        UserRoleDTO userRoleDTO = new UserRoleDTO();
//        userRoleDTO.setRole(role);
//        userRoleDTO.setUser(user);
//        userRoleDTO.setCreatedBy("System");
//        userRoleDTO.setModifiedBy("System");
//        UserRole data = userRoleService.save(userRoleDTO);
//        if(data != null){
//            responseData.setPayload(data);
//            responseData.setMessages(message);
//        }
        return new ResponseEntity<ResponseData>(responseData, HttpStatus.CREATED);
    }
}

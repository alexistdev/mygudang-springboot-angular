package com.alexistdev.mygudang.controller;

import com.alexistdev.mygudang.dto.*;
import com.alexistdev.mygudang.entity.Menu;
import com.alexistdev.mygudang.entity.RoleMenu;
import com.alexistdev.mygudang.entity.User;
import com.alexistdev.mygudang.entity.UserRole;
import com.alexistdev.mygudang.service.RoleMenuService;
import com.alexistdev.mygudang.service.UserRoleService;
import com.alexistdev.mygudang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    public static final String LOGIN = "/login";
    public static final String TEST = "/test";

    private UserService userservice;

    @Autowired
    private UserRoleService userRoleService;

    @Autowired
    private RoleMenuService roleMenuService;

    public AuthController(UserService userservice) {
        this.userservice = userservice;
    }

    @PostMapping(value = LOGIN)
    public ResponseEntity<ResponseData<LoginResDTO>> doLogin(@RequestBody LoginDTO user) throws Exception {
        List<String> message = new ArrayList<>();
        ResponseData<LoginResDTO> responseData = new ResponseData<>();
        User whoIam = userservice.findByEmail(user.getUn());
        if(whoIam != null){
            if(userservice.authenticateLogin(user.getPw(),whoIam.getPassword())){
                List<Menu> menuList = new ArrayList<>();
                List<UserRole> userRoleList = userRoleService.getByUserId(whoIam.getId());
                String roleId = userRoleList.get(0).getRole().getId();
                List<RoleMenu> roleMenuList = roleMenuService.getByRoleId(roleId);
                roleMenuList.forEach((result)-> menuList.add(result.getMenu()));
                LoginResDTO loginResDTO = new LoginResDTO();
                loginResDTO.setId(whoIam.getId());
                loginResDTO.setName(whoIam.getName());
                loginResDTO.setEmail(whoIam.getEmail());
                loginResDTO.setPhone(whoIam.getPhone());
                loginResDTO.setIsActive(whoIam.getIsActive());
                loginResDTO.setMenuList(menuList);
                loginResDTO.setRoleId(roleId);
                responseData.setStatus(true);
                message.add("Data berhasil didapatkan");
                responseData.setMessages(message);
                responseData.setPayload(loginResDTO);
                return ResponseEntity.ok(responseData);
            }
        }
        message.add("Gagal");
        responseData.setStatus(false);
        responseData.setMessages(message);
        responseData.setPayload(null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    }


    @GetMapping(value = TEST)
    public ResponseEntity<ResponseData<User>> doTesting() {
        ResponseData<User> responseData = new ResponseData<>();
        responseData.setStatus(true);
        return ResponseEntity.ok(responseData);
    }
}

package com.alexistdev.mygudang.controller;

import com.alexistdev.mygudang.dao.AuthDAO;
import com.alexistdev.mygudang.dao.MenuDAO;
import com.alexistdev.mygudang.dto.LoginResDTO;
import com.alexistdev.mygudang.dto.ResponseData;
import com.alexistdev.mygudang.entity.Menu;
import com.alexistdev.mygudang.entity.RoleMenu;
import com.alexistdev.mygudang.entity.User;
import com.alexistdev.mygudang.service.RoleMenuService;
import com.alexistdev.mygudang.service.RoleService;
import com.alexistdev.mygudang.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

@RestController
@RequestMapping("/v1/auth")
public class AuthController {
    public static final String LOGIN = "/login";

    @Autowired
    private UserService userservice;

    @Autowired
    private RoleService roleService;



    @Autowired
    private RoleMenuService roleMenuService;

    public AuthController(UserService userservice) {
        this.userservice = userservice;
    }

    @PostMapping(value = LOGIN)
    public ResponseEntity<ResponseData<LoginResDTO>> doLogin(@RequestBody AuthDAO authDAO) throws Exception {
        ResourceBundle resourceBundle = ResourceBundle.getBundle("message");
        ResponseData<LoginResDTO> responseData = new ResponseData<>();
        User whoIam = userservice.findByEmail(authDAO.getUsername());
        responseData.setStatus(false);
        responseData.setMessages(resourceBundle.getString("failed"));
        responseData.setData(null);
        if (whoIam != null) {
            if (userservice.authenticateLogin(authDAO.getPassword(), whoIam.getPassword())) {
                LoginResDTO loginResDTO = LoginResDTO.builder()
                        .id(whoIam.getId())
                        .name(whoIam.getName())
                        .email(whoIam.getEmail())
                        .phone(whoIam.getPhone())
                        .isActive(whoIam.getIsActive())
                        .menuList(getDataMenuList(whoIam))
                        .roleId(whoIam.getId())
                        .build();
                responseData.setStatus(true);
                responseData.setMessages(resourceBundle.getString("success"));
                responseData.setData(loginResDTO);
                return ResponseEntity.ok(responseData);
            }
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    }

    private List<MenuDAO> getDataMenuList(User user) throws Exception {
        List<MenuDAO> menuList = new ArrayList<>();
        List<RoleMenu> roleMenuList = roleMenuService.getByRoleId(user.getRole().getId());
        if (ObjectUtils.isEmpty(roleMenuList)) {
            return menuList;
        }
        roleMenuList.forEach((result) -> menuList.add(convertDAO(result.getMenu())));
        return menuList;
    }

    private MenuDAO convertDAO(Menu menu) {
        ModelMapper modelMapper = new ModelMapper();
        return modelMapper.map(menu, MenuDAO.class);
    }
}

package com.alexistdev.mygudang.dto;

import com.alexistdev.mygudang.dao.MenuDAO;
import com.alexistdev.mygudang.entity.Menu;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class LoginResDTO {
    private String id;
    private String name;
    private String email;
    private String phone;
    private String roleId;
    private int isActive;
    private List<MenuDAO> menuList;
}

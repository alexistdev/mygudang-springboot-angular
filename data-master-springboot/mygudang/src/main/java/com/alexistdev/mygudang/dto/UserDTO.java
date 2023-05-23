package com.alexistdev.mygudang.dto;

import com.alexistdev.mygudang.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private int id;
    private String name;
    private String email;
    private String phone;
    private int isActive;
    private Role role;
}

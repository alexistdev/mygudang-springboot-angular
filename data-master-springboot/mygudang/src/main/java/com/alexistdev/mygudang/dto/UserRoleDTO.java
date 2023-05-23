package com.alexistdev.mygudang.dto;

import com.alexistdev.mygudang.entity.Role;
import com.alexistdev.mygudang.entity.User;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserRoleDTO {
    private User user;
    private Role role;
    private String createdBy;
    private String modifiedBy;
}

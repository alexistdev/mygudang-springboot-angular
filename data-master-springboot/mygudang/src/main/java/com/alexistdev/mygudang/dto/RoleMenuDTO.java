package com.alexistdev.mygudang.dto;

import com.alexistdev.mygudang.entity.Menu;
import com.alexistdev.mygudang.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RoleMenuDTO {
    private Role role;
    private Menu menu;
    private String createdBy;
    private String modifiedBy;
}

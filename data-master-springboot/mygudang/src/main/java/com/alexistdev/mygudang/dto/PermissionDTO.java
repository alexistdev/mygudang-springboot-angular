package com.alexistdev.mygudang.dto;

import com.alexistdev.mygudang.entity.Role;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PermissionDTO {

    public Role Role;

    public String slug;

    public PermissionDTO() {
    }

}

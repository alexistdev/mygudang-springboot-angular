package com.alexistdev.mygudang.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RoleDAO {
    private String createdBy;
    private String modifiedBy;
    private String name;
    private String description;
    private String status;
}

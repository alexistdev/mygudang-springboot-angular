package com.alexistdev.mygudang.dao;

import com.alexistdev.mygudang.dto.BasicInfo;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
public class RoleDAO {

    private String createdBy;
    private String modifiedBy;
    @NotNull(message = "Name should not be empty", groups = BasicInfo.class)
    private String name;
    @NotNull(message = "Description should not be empty", groups = BasicInfo.class)
    private String description;
    private String status;

    public RoleDAO() {
    }

    public RoleDAO(String name,String description,String status, String createdBy,String modifiedBy) {
        this.name = name;
        this.description = description;
        this.status = status;
        this.createdBy = createdBy;
        this.modifiedBy = modifiedBy;
    }
}

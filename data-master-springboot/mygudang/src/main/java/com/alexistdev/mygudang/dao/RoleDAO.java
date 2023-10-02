package com.alexistdev.mygudang.dao;

import com.alexistdev.mygudang.dto.BasicInfo;
import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RoleDAO {
    private String createdBy;
    private String modifiedBy;
    @NotNull(message = "Name should not be empty", groups = BasicInfo.class)
    private String name;
    @NotNull(message = "Description should not be empty", groups = BasicInfo.class)
    private String description;
    private String status;
}

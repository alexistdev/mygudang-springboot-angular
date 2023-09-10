package com.alexistdev.mygudang.dao;

import jakarta.validation.constraints.NotNull;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RoleDAO {

    private String createdBy;
    private String modifiedBy;
    @NotNull(message = "Name should not be empty")
    private String name;
    @NotNull(message = "Description should not be empty")
    private String description;
    private String status;


}

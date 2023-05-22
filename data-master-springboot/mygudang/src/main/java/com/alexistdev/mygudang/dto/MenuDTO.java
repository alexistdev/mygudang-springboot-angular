package com.alexistdev.mygudang.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MenuDTO {
    private String label;
    private String url;
    private String description;
    private String menuCode;
    private String createdBy;
    private String modifiedBy;

    public MenuDTO() {
    }
}

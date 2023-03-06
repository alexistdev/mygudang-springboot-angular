package com.alexistdev.mygudang.dto;

import jakarta.validation.constraints.NotEmpty;

public class CategoryDTO {

    private String code;

    @NotEmpty(message = "Name is required")
    private String name;

    public String getCode() {
        return code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

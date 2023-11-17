package com.alexistdev.mygudang.request;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MenuRequest {
    private String label;
    private String url;
    private String description;
    private String name;
    private int order;
    private String createdBy;
    private String modifiedBy;
}

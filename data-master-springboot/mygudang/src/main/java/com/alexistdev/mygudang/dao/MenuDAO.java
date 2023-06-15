package com.alexistdev.mygudang.dao;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class MenuDAO {
    private String label;
    private String url;
    private String description;
    private String name;
    private int order;
}

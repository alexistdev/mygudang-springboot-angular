package com.alexistdev.mygudang.dto;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class ResponseData<T> {
    private boolean status;
    private String messages="";

    private T data;

    public boolean isStatus() {
        return status;
    }

}

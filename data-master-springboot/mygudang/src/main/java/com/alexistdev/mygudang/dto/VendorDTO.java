package com.alexistdev.mygudang.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;

public class VendorDTO {

    @NotEmpty(message = "Name is required")
    private String name;

    private String code;

    @NotEmpty(message = "Address is required")
    private String address;
    @NotEmpty(message = "Email is required")
    @Email(message = "Email is invalid")
    private String email;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}

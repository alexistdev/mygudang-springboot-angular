package com.alexistdev.mygudang.exception;

import com.alexistdev.mygudang.master.MasterConstant;

import java.util.ResourceBundle;

public class DuplicatException extends Exception{

    public DuplicatException(String name, ResourceBundle resourceBundle) {
        super("Role "+name + " " + resourceBundle.getString("duplicate"));
    }
}

package com.alexistdev.mygudang.exception;

import com.alexistdev.mygudang.master.MasterConstant;

public class DuplicatException extends Exception{

    public DuplicatException(String name) {
        super("Role "+name + " " + MasterConstant.Response.DUPLICATE);
    }
}

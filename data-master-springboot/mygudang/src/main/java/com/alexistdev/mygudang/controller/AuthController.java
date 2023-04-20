package com.alexistdev.mygudang.controller;

import com.alexistdev.mygudang.dto.LoginDTO;
import com.alexistdev.mygudang.dto.ResponseData;
import com.alexistdev.mygudang.entity.User;
import com.alexistdev.mygudang.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.security.SecureRandom;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    public static final String LOGIN = "/login";

    @Autowired
    private UserService userservice;

    @Autowired
    private PasswordEncoder passwordEncoder;


    @PostMapping(value = LOGIN)
    public ResponseEntity<ResponseData<User>> doLogin(@RequestBody LoginDTO user){
        try{
            ResponseData<User> responseData = new ResponseData<>();
            User whoIam = this.userservice.findByEmail(user.getUn());
//            if(whoIam != null){
//                if(whoIam.getPassword().equals(passwordEncoder.encode(user.getPw()))){
                    responseData.setStatus(true);
                    responseData.setPayload(whoIam);
                    return ResponseEntity.ok(responseData);
//                }
//            }
//            responseData.setStatus(false);
//            responseData.setPayload(null);
//            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
        }catch (Exception e){
            throw e;
        }
    }

}

package com.alexistdev.mygudang.controller;

import com.alexistdev.mygudang.dto.LoginDTO;
import com.alexistdev.mygudang.dto.ResponseData;
import com.alexistdev.mygudang.dto.UserDTO;
import com.alexistdev.mygudang.entity.User;
import com.alexistdev.mygudang.service.UserService;
import com.alexistdev.mygudang.service.UserServiceold;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/auth")
public class AuthController {
    public static final String LOGIN = "/login";
    public static final String TEST = "/test";

    private UserService userservice;

    public AuthController(UserService userservice) {
        this.userservice = userservice;
    }

    @PostMapping(value = LOGIN)
    public ResponseEntity<ResponseData<UserDTO>> doLogin(@RequestBody LoginDTO user) throws Exception {
        List<String> message = new ArrayList<>();
        ResponseData<UserDTO> responseData = new ResponseData<>();
        User whoIam = userservice.findByEmail(user.getUn());
        if(whoIam != null){
            if(userservice.authenticateLogin(user.getPw(),whoIam.getPassword())){
                UserDTO userDTO = new UserDTO();
                userDTO.setId(whoIam.getId());
                userDTO.setName(whoIam.getName());
                userDTO.setEmail(whoIam.getEmail());
                userDTO.setPhone(whoIam.getPhone());
                userDTO.setIsActive(whoIam.getIsActive());
                userDTO.setRole(whoIam.getRole());
                responseData.setStatus(true);
                message.add("Data berhasil didapatkan");
                responseData.setMessages(message);
                responseData.setData(userDTO);
                return ResponseEntity.ok(responseData);
            }
        }
        message.add("Gagal");
        responseData.setStatus(false);
        responseData.setMessages(message);
        responseData.setPayload(null);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
    }

    @GetMapping(value = TEST)
    public ResponseEntity<ResponseData<User>> doTesting() {
        ResponseData<User> responseData = new ResponseData<>();
        responseData.setStatus(true);
        return ResponseEntity.ok(responseData);
    }
}

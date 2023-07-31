package com.alexistdev.mygudang.service;

import com.alexistdev.mygudang.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootTest
public class UserServiceTest {

    @Autowired
    private UserService userService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Test
    @Disabled
    public void getUserIdTest() throws Exception {
        User insertUser = new User();
        insertUser.setPhone("0823123123");
        insertUser.setEmail("hendra@gmail.com");
        insertUser.setName("hendra");
        insertUser.setPassword("1234");
        insertUser.setIsActive(1);
        User resultUser = userService.save(insertUser);
        User getDataUser = userService.getById(resultUser.getId());
        Assertions.assertNotNull(getDataUser);
        Assertions.assertEquals(resultUser.getId(), getDataUser.getId());
    }

    @Test
    @Disabled
    public void authenticateTest() throws Exception {
        String password1 = "1234";
        String password2 = passwordEncoder.encode(password1);
        boolean result = userService.authenticateLogin(password1, password2);
        Assertions.assertTrue(result);
    }

    @Test
    @Disabled
    public void getUserByEmailTest() throws Exception{
        User insertUser2 = new User();
        insertUser2.setPhone("08231231232");
        insertUser2.setEmail("hendra2@gmail.com");
        insertUser2.setName("hendra2");
        insertUser2.setPassword("1234");
        insertUser2.setIsActive(1);
        User resultUser2 = userService.save(insertUser2);
        User getUser = userService.findByEmail(resultUser2.getEmail());
        Assertions.assertNotNull(getUser);
        Assertions.assertEquals(resultUser2.getId(), getUser.getId());
    }
}

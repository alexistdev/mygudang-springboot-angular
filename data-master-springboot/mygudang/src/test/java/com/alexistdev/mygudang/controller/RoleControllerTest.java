package com.alexistdev.mygudang.controller;

import com.alexistdev.mygudang.config.Helper;
import com.alexistdev.mygudang.entity.Role;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.web.context.WebApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class RoleControllerTest {
    @Autowired
    WebApplicationContext webApplicationContext;

    private final Helper helper = new Helper();

    private final String uri = "/api/roles";

    @Test
    public void addRoleTest() throws Exception {
        MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        Role role = new Role();
        role.setStatus("1");
        role.setName("Admin");
        role.setDescription("Administration");
        role.setModifiedBy("System");
        role.setCreatedBy("System");
        String inputJson = helper.convertJSON(role);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
}

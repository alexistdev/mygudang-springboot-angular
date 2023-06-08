package com.alexistdev.mygudang.controller;

import com.alexistdev.mygudang.config.Helper;
import com.alexistdev.mygudang.dto.MenuDTO;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
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
public class MenuControllerTest {
    @Autowired
    WebApplicationContext webApplicationContext;
    private final Helper helper = new Helper();
    private final String uri = "/api/menu";

    @Test
    public void addMenuTest() throws Exception{
        MockMvc mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
        MenuDTO insertMenu = new MenuDTO();
        insertMenu.setName("dashboard");
        insertMenu.setUrl("/dashboard");
        insertMenu.setLabel("fa-dashboard");
        insertMenu.setDescription("Halaman dashboard");
        insertMenu.setCreatedBy("System");
        insertMenu.setModifiedBy("System");
        String inputJson = helper.convertJSON(insertMenu);
        MvcResult mvcResult = mvc.perform(MockMvcRequestBuilders.post(uri)
                .contentType(MediaType.APPLICATION_JSON_VALUE).content(inputJson)).andReturn();
        int status = mvcResult.getResponse().getStatus();
        assertEquals(200, status);
    }
}

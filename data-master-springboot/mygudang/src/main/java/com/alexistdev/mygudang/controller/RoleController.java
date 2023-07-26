package com.alexistdev.mygudang.controller;


import com.alexistdev.mygudang.entity.Role;
import com.alexistdev.mygudang.repository.RoleRepository;
import com.alexistdev.mygudang.response.CommonPaging;
import com.alexistdev.mygudang.response.CommonResponse;
import com.alexistdev.mygudang.response.CommonResponsePaging;
import com.alexistdev.mygudang.service.RoleService;
import com.alexistdev.mygudang.utils.JsonUtil;
import com.fasterxml.jackson.databind.ObjectWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/roles")
public class RoleController {

    private Logger logger = LoggerFactory.getLogger(RoleController.class);

    public static final String GET_LIST_ROLE = "/list";
    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping
    public Role create(@RequestBody Role role) throws Exception{
        return roleService.save(role);
    }

    @GetMapping(value = GET_LIST_ROLE)
    public String getRolePaging(@RequestParam(name = "pageSize",defaultValue = "10") String pageSize,
                                @RequestParam(name = "pageNo",defaultValue = "0") String page,
                                @RequestParam(name = "sortDir",defaultValue = "1") String sortDir,
                                @RequestParam(name = "sort",defaultValue = "id") String sort,
                                @RequestParam(name = "field",defaultValue = "") String field,
                                @RequestParam(name = "value",defaultValue = "") String value
                                ) throws Exception{
        CommonPaging<Role> rolePage = roleService.findByPaging(Integer.parseInt(pageSize),Integer.parseInt(page),sortDir,sort,field,value);
        CommonResponsePaging<Role> resp = new CommonResponsePaging<>(rolePage);
        ObjectWriter writer = JsonUtil.generateDefaultJsonWriter();
        return writer.writeValueAsString(resp);
    }
}

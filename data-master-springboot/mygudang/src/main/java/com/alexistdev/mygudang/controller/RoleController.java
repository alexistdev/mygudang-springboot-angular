package com.alexistdev.mygudang.controller;


import com.alexistdev.mygudang.dao.RoleDAO;
import com.alexistdev.mygudang.dto.ResponseData;
import com.alexistdev.mygudang.entity.Role;
import com.alexistdev.mygudang.master.MasterConstant;
import com.alexistdev.mygudang.repository.RoleRepository;
import com.alexistdev.mygudang.response.CommonPaging;
import com.alexistdev.mygudang.response.CommonResponsePaging;
import com.alexistdev.mygudang.service.RoleService;
import com.alexistdev.mygudang.utils.JsonUtil;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.validation.Valid;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;


@RestController
@RequestMapping("/v1")
public class RoleController {

    private Logger logger = LoggerFactory.getLogger(RoleController.class);

    public static final String GET_LIST_ROLE = "/list";
    public static final String ROLE_POST = "/role";
    @Autowired
    private RoleService roleService;

    @Autowired
    private RoleRepository roleRepository;

    @PostMapping(value = ROLE_POST)
    public ResponseEntity<?> create(@Valid @RequestBody RoleDAO roleDao){
        ResponseData<Role> responseData = new ResponseData<>();
        responseData.setStatus(false);
        try{
            Role result =roleService.save(roleDao);
            responseData.setStatus(true);
            responseData.setData(result);
            responseData.setMessages(MasterConstant.Response.SUCCESS_DESC);
            return new ResponseEntity<ResponseData<?>>(responseData, HttpStatus.CREATED);
        } catch (Exception e) {
            responseData.setMessages(e.getMessage());
            return new ResponseEntity<ResponseData<?>>(responseData, HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping(value = ROLE_POST+"/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody RoleDAO roleDAO, @PathVariable String id){
        ResponseData<Optional<Role>> responseData = new ResponseData<>();
        responseData.setStatus(false);
        try{
            Optional<Role> result = roleService.update(roleDAO,id);
            if(result.isEmpty()){
                responseData.setMessages(MasterConstant.Response.DATA_NOT_FOUND);
                return new ResponseEntity<ResponseData<?>>(responseData, HttpStatus.BAD_REQUEST);
            }
            responseData.setStatus(true);
            responseData.setData(result);
            responseData.setMessages(MasterConstant.Response.SUCCESS_UPDATED);
            return new ResponseEntity<ResponseData<?>>(responseData, HttpStatus.CREATED);
        } catch (Exception e) {
            responseData.setMessages(e.getMessage());
            return new ResponseEntity<ResponseData<?>>(responseData, HttpStatus.BAD_REQUEST);
        }
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

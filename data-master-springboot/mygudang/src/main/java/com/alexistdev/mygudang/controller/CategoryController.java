package com.alexistdev.mygudang.controller;

import com.alexistdev.mygudang.dto.ResponseData;
import com.alexistdev.mygudang.entity.Category;
import com.alexistdev.mygudang.response.CommonResponse;
import com.alexistdev.mygudang.service.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    public static final String ADD_CATEGORY = "/add";
    @Autowired
    private CategoryService categoryService;

    @PostMapping(value = ADD_CATEGORY)
    public ResponseEntity<ResponseData<Category>> create(@Valid @RequestBody Category category, Errors errors){
        ResponseData<Category> responseData = new ResponseData<>();
        try{
            if (errors.hasErrors()) {
                for(ObjectError error: errors.getAllErrors()){
                    responseData.getMessages().add(error.getDefaultMessage());
                }
                responseData.setStatus(false);
                responseData.setData(null);
                return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(responseData);
            }
            responseData.setStatus(true);
            responseData.setData(categoryService.save(category));
            return ResponseEntity.ok(responseData);
        }catch (Exception e){
            e.printStackTrace();
            throw e;
        }
    }

//    private boolean hasDuplicate(Category category){
//
//    }
}

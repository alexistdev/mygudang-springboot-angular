package com.alexistdev.mygudang.service;

import com.alexistdev.mygudang.entity.Category;
import com.alexistdev.mygudang.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Transactional
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    private Date date= new Date();
    private static AtomicLong idCounter = new AtomicLong();

    public Category save(Category category){
        Long categoryId = idCounter.getAndIncrement();
        if(categoryId == 0L){
            categoryId = 1L;
        }
        category.setCreatedDate(date);
        category.setUpdatedDate(date);
        category.setCode(String.valueOf(categoryId));
        return categoryRepository.save(category);
    }
}

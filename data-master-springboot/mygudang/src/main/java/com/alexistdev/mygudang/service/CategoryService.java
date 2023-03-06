package com.alexistdev.mygudang.service;

import com.alexistdev.mygudang.entity.Category;
import com.alexistdev.mygudang.repository.CategoryRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.Optional;
import java.util.UUID;
import java.util.concurrent.atomic.AtomicLong;

@Service
@Transactional
public class CategoryService {
    @Autowired
    private CategoryRepository categoryRepository;

    private Date date= new Date();
    private static AtomicLong idCounter = new AtomicLong();

    public Category save(Category category){
        Long codeId = idCounter.getAndIncrement();
        if(codeId == 0L){
            codeId = 1L;
        }
        category.setCreatedDate(date);
        category.setUpdatedDate(date);
        category.setCode(String.valueOf(codeId));
        return categoryRepository.save(category);
    }

    public Category findOne(UUID id){
        Optional<Category> category= categoryRepository.findById(id);
        if(!category.isPresent()){
            return null;
        }
        return category.get();
    }

    public Iterable<Category> findAll(){
        return categoryRepository.findAll();
    }

    public void removeOne(UUID id){
        categoryRepository.deleteById(id);
    }
}

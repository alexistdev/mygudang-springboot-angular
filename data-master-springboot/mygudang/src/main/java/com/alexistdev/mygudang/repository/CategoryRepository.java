package com.alexistdev.mygudang.repository;

import com.alexistdev.mygudang.entity.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoryRepository extends CrudRepository<Category,Long> {

    List<Category> findByNameContains(String name);
}

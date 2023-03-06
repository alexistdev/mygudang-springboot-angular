package com.alexistdev.mygudang.repository;

import com.alexistdev.mygudang.entity.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface CategoryRepository extends CrudRepository<Category, UUID> {

}

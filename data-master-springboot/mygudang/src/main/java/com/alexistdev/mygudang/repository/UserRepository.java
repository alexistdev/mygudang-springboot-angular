package com.alexistdev.mygudang.repository;

import com.alexistdev.mygudang.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepository extends CrudRepository<User,Long> {

    List<User> findByNameContains(String name);
}

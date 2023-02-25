package com.alexistdev.mygudang.dto;

import com.alexistdev.mygudang.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserDto extends CrudRepository<User,Long> {

    List<User> findByNameContains(String name);
}

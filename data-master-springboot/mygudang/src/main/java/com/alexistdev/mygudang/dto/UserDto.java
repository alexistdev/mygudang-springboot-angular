package com.alexistdev.mygudang.dto;

import com.alexistdev.mygudang.entity.User;
import org.springframework.data.repository.CrudRepository;

public interface UserDto extends CrudRepository<User,Long> {

}

package com.alexistdev.mygudang.repository;

import com.alexistdev.mygudang.entity.Role;
import com.alexistdev.mygudang.entity.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface RoleRepository extends CrudRepository<Role,String> {

    List<Role> findByNameContains(String name);
}

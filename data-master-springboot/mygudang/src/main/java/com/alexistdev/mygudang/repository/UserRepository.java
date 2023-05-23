package com.alexistdev.mygudang.repository;

import com.alexistdev.mygudang.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.UUID;

public interface UserRepository extends JpaRepository<User, String> {

    List<User> findByNameContains(String name);

    User findByEmailContains(String email);
}

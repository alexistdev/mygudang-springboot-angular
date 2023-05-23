package com.alexistdev.mygudang.repository;

import com.alexistdev.mygudang.entity.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRoleRepository extends JpaRepository<UserRole,String> {
    List<UserRole> findByUserId(String userid);
}

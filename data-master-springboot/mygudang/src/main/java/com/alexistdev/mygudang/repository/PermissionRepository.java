package com.alexistdev.mygudang.repository;

import com.alexistdev.mygudang.dto.PermissionDTO;
import com.alexistdev.mygudang.entity.Permission;
import com.alexistdev.mygudang.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface PermissionRepository extends CrudRepository<Permission,Long> {

}

package com.alexistdev.mygudang.repository;

import com.alexistdev.mygudang.entity.Permission;
import com.alexistdev.mygudang.entity.RoleMenu;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface RoleMenuRepository extends JpaRepository<RoleMenu,String> {

}

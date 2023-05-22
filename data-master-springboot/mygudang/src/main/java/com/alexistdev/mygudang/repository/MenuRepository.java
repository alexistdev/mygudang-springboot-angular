package com.alexistdev.mygudang.repository;

import com.alexistdev.mygudang.entity.Menu;
import com.alexistdev.mygudang.entity.Role;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface MenuRepository extends JpaRepository<Menu,Long> {

}

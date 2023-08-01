package com.alexistdev.mygudang.service;

import com.alexistdev.mygudang.dao.RoleDAO;
import com.alexistdev.mygudang.entity.Role;
import com.alexistdev.mygudang.response.CommonPaging;

import java.util.List;

public interface RoleService {
    RoleDAO save(RoleDAO role) throws Exception;

    Role getByName(String name) throws Exception;

    Role getById(String id) throws Exception;

    List<Role> getAll() throws Exception;

    CommonPaging<Role> findByPaging(int var1, int var2, String var3, String var4, String var5, String value);
}

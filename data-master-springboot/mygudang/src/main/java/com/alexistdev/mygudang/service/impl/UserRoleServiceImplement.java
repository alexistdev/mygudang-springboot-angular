package com.alexistdev.mygudang.service.impl;

import com.alexistdev.mygudang.dto.UserRoleDTO;
import com.alexistdev.mygudang.entity.UserRole;
import com.alexistdev.mygudang.repository.UserRoleRepository;
import com.alexistdev.mygudang.service.UserRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.Date;
import java.util.List;

@Repository
public class UserRoleServiceImplement implements UserRoleService {

    @Autowired
    private UserRoleRepository userRoleRepository;

    @Override
    public UserRole save(UserRoleDTO userRoleDTO) throws Exception {
        Date now = new Date();
        UserRole userRoleInsert = new UserRole();
        userRoleInsert.setRole(userRoleDTO.getRole());
        userRoleInsert.setUser(userRoleDTO.getUser());
        userRoleInsert.setCreatedAt(now);
        userRoleInsert.setUpdatedAt(now);
        userRoleInsert.setCreatedBy(userRoleDTO.getCreatedBy());
        userRoleInsert.setModifiedBy(userRoleDTO.getModifiedBy());
        return userRoleRepository.save(userRoleInsert);
    }

    @Override
    public List<UserRole> getByUserId(String userId) throws Exception {
        return userRoleRepository.findByUserId(userId);
    }

//    @Override
//    public UserRole getById(String UserId,String RoleId) throws Exception {
//        return userRoleRepository.findByUserIdRoleId(UserId,RoleId);
//    }
}

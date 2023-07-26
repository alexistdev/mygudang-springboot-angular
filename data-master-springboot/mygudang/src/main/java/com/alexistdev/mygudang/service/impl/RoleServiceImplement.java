package com.alexistdev.mygudang.service.impl;

import com.alexistdev.mygudang.controller.RoleController;
import com.alexistdev.mygudang.entity.Role;
import com.alexistdev.mygudang.repository.RoleRepository;
import com.alexistdev.mygudang.response.CommonPaging;
import com.alexistdev.mygudang.service.RoleService;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.persistence.criteria.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Repository
public class RoleServiceImplement implements RoleService {

    private Logger logger = LoggerFactory.getLogger(RoleController.class);

    @PersistenceContext
    private EntityManager em;

    @Autowired
    RoleRepository roleRepository;

    @Override
    public Role save(Role role) throws Exception
    {
        Date now = new Date();
        Role insertRole = new Role();
        insertRole.setName(role.getName());
        insertRole.setDescription(role.getDescription());
        insertRole.setCreatedBy(role.getCreatedBy());
        insertRole.setModifiedBy(role.getModifiedBy());
        insertRole.setCreatedAt(now);
        insertRole.setUpdatedAt(now);
        return roleRepository.save(insertRole);
    }

    @Override
    public Role getById(String id) throws Exception {
        return roleRepository.findById(id).orElse(null);
    }

    @Override
    public List<Role> getAll() throws Exception {
        List<Role> roleList = new ArrayList<>();
        Iterable<Role> iterable = roleRepository.findAll();
        iterable.forEach(roleList::add);
        return roleList;
    }

    @Override
    public CommonPaging<Role> findByPaging(int pageSize, int page, String sortDir, String sort, String field,String value) {
        CommonPaging<Role> roleListPaging = new CommonPaging<>();
        roleListPaging.setPage(page);
        roleListPaging.setRowPerPage(pageSize);
        roleListPaging.setTotalData(countRoleList(field,value,"1"));
        roleListPaging.setData(this.findByReturnList(roleListPaging.getStartRow(),pageSize,sortDir,sort,field,value));
        return roleListPaging;
    }

    private int countRoleList(String field,String value,String statusFlag){
        CriteriaBuilder critB = em.getCriteriaBuilder();
        CriteriaQuery<Long> query = critB.createQuery(Long.class);
        Root<Role> rootRole = query.from(Role.class);
        query.select(critB.count(rootRole)).where(
              critB.and(
                      critB.equal(rootRole.get("status"), statusFlag),
                      createSingleSearchPredicate(rootRole, field, value)

              )
        );
        return em.createQuery(query).getSingleResult().intValue();
    }

    private Predicate createSingleSearchPredicate(Root<Role> rootRole,String field, Object value){
        CriteriaBuilder critB = em.getCriteriaBuilder();
        if(!value.equals("")){
            return !value.equals("") ? critB.equal(rootRole.get(field),value) : critB.like(rootRole.get(field), "%" + value + "%");
        } else {
            return critB.and(new Predicate[0]);
        }
    }

    private List<Role> findByReturnList(int startRow, int rowPerPage, String sortDir, String sort, String field, String value){
        CriteriaBuilder critB = this.em.getCriteriaBuilder();
        CriteriaQuery<Role> query = critB.createQuery(Role.class);
        Root<Role> rootRole = query.from(Role.class);
        Order o = sortDir.equals("1") ? critB.asc(rootRole.get(sort)) : critB.desc(rootRole.get(sort));
//        query.select(rootRole).where(critB.and(critB.equal(rootRole.get("status"),"1"), this.createSingleSearchPredicate(rootRole, field,value))).orderBy(new Order[]{o});
        TypedQuery<Role> q = this.em.createQuery(query);
        q.setFirstResult(startRow);
        q.setMaxResults(rowPerPage);
        return q.getResultList();
    }
}

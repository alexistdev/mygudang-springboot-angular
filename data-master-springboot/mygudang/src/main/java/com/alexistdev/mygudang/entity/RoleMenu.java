package com.alexistdev.mygudang.entity;

import com.alexistdev.mygudang.dao.MenuDAO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.util.Date;

@Getter
@Setter
@Entity
@NoArgsConstructor
@Table(name = "role_menu")
public class RoleMenu extends AuditEntity {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name = "uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "VARCHAR(50)")
    private String id;

    @JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id",nullable = false)
    private Role role;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "menu_id",nullable = false)
    private Menu menu;

    @Builder
    public RoleMenu(Date createdAt, Date updatedAt, String createdBy, String modifiedBy, Role role, Menu menu) {
        super(createdAt, updatedAt, createdBy, modifiedBy);
        this.role = role;
        this.menu = menu;
    }
}

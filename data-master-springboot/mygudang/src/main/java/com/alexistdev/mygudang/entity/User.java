package com.alexistdev.mygudang.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

import java.io.Serializable;

@Entity
@Getter
@Setter
@Table(name = "users")
public class User extends AuditEntity implements Serializable {

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "VARCHAR(50)")
    private String id;

    @ManyToOne
    @JoinColumn(name = "role_id")
    private Role role;

    @NotEmpty(message = "Name is required")
    @Column(name = "name")
    private String name;

    @NotEmpty(message = "Email is required")
    @Column(name = "email", unique = true)
    private String email;

    @Column(name = "phone", length = 125, nullable = true)
    private String phone;

    @NotEmpty(message = "Password is required")
    @Column(name = "password")
    private String password;

    @Column(name = "isActive")
    private int isActive;

}

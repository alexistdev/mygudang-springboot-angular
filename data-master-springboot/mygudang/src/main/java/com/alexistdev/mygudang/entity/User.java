package com.alexistdev.mygudang.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;


import java.io.Serializable;
import java.time.Instant;
import java.util.Date;

import static jakarta.persistence.TemporalType.TIMESTAMP;

@Entity
@Getter
@Setter
@Table(name="users")
public class User implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="email", unique = true)
    private String email;

    @Column(name="phone", length= 125)
    private String phone;

    @Column(name="password")
    private String password;

    @Column(name="isActive")
    private int isActive;

    @CreatedDate
    @Temporal(TIMESTAMP)
    private Date createdDate;

    public User() {
    }

    public User(int id, String name, String email, String phone, String password, int isActive) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.phone = phone;
        this.password = password;
        this.isActive = isActive;
    }

}

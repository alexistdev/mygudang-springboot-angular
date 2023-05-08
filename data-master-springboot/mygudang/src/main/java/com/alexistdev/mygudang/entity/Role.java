package com.alexistdev.mygudang.entity;

import jakarta.persistence.*;
import lombok.*;
import org.aspectj.lang.annotation.After;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.util.Date;

import static jakarta.persistence.TemporalType.TIMESTAMP;

@Getter
@Setter
@Entity
@Table(name="roles")
public class Role extends AuditEntity {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="level")
    private int level;

}

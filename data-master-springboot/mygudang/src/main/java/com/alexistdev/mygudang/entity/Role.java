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
public class Role implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name="name")
    private String name;

    @Column(name="level")
    private int level;

    @CreatedDate
    @Temporal(TIMESTAMP)
    private Date createdAt;

    @CreatedDate
    @Temporal(TIMESTAMP)
    private Date updatedAt;

    public Role() {
    }

    public Role(int id, String name, int level, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.level = level;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}

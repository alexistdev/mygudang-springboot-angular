package com.alexistdev.mygudang.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import org.springframework.data.annotation.CreatedDate;

import java.io.Serializable;
import java.util.Date;

import static jakarta.persistence.TemporalType.TIMESTAMP;

@Entity
@Table(name="categories")
@Getter
@Setter
public class Category extends AuditEntity {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column(name="code",unique = true)
    private String code;

    @Column(name="name",unique = true)
    private String name;

    @CreatedDate
    @Temporal(TIMESTAMP)
    private Date createdDate;

    @CreatedDate
    @Temporal(TIMESTAMP)
    private Date updatedDate;

}

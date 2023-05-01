package com.alexistdev.mygudang.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;
import java.io.Serializable;
import java.util.Date;
import static jakarta.persistence.TemporalType.TIMESTAMP;

@Getter
@Setter
@Entity
@Table(name="permissions")
public class Permission  implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty(message="roleId is required")
    @Column(name="role_id")
    private int roleId;

    @NotEmpty(message="Slug is required")
    @Column(name="slug")
    private String slug;

    @CreatedDate
    @Temporal(TIMESTAMP)
    private Date createdAt;

    @CreatedDate
    @Temporal(TIMESTAMP)
    private Date updatedAt;

    public Permission() {
    }

    public Permission(int id, int roleId, String slug, Date createdAt, Date updatedAt) {
        this.id = id;
        this.roleId = roleId;
        this.slug = slug;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }
}

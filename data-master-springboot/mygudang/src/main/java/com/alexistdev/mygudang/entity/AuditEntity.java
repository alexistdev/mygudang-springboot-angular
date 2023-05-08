package com.alexistdev.mygudang.entity;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;
import jakarta.persistence.Temporal;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedDate;

import java.util.Date;

import static jakarta.persistence.TemporalType.TIMESTAMP;

@Getter
@Setter
@MappedSuperclass
public class AuditEntity {

    @CreatedDate
    @Temporal(TIMESTAMP)
    @Column(name="created_at")
    private Date createdAt;

    @CreatedDate
    @Temporal(TIMESTAMP)
    @Column(name="updated_at")
    private Date updatedAt;

    public AuditEntity() {
    }
}

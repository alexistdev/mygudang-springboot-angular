package com.alexistdev.mygudang.entity;

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
@Table(name="menus")
public class Menu extends AuditEntity  {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "uuid2")
    @GenericGenerator(name="uuid2", strategy = "uuid2")
    @Column(name = "id", columnDefinition = "VARCHAR(50)")
    private String id;

    @Column(name="name", nullable = false)
    private String name;

    @Column(name="label", nullable = false)
    private String label;

    @Column(name="url", nullable = false)
    private String url;

    @Column(name="description", nullable = false)
    private String description;

    @Column(name="order_no", nullable = false)
    private int order;

    @Builder
    public Menu(Date createdAt, Date updatedAt, String createdBy, String modifiedBy, String name, String label, String url, String description, int order) {
        super(createdAt, updatedAt, createdBy, modifiedBy);
        this.name = name;
        this.label = label;
        this.url = url;
        this.description = description;
        this.order = order;
    }
}

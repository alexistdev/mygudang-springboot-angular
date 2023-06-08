package com.alexistdev.mygudang.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;

@Getter
@Setter
@Entity
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


}

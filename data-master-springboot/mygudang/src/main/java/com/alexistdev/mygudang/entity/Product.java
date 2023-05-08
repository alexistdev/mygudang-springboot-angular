package com.alexistdev.mygudang.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.GenericGenerator;
import java.io.Serializable;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name="products")
public class Product extends AuditEntity {
    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "code", nullable = false)
    private String code;

    @NotEmpty(message = "Name is required")
    @Column(name = "nama_product", nullable = false, length = 155)
    private String name;

    @NotEmpty(message = "Price is required")
    @Column(name = "harga", nullable = false)
    private int price;

    @ManyToOne
    private Category category;

    @ManyToMany
    @JoinTable(
            name = "products_vendors",
            joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name="vendor_id")
    )
    private Set<Vendor> vendors;

}

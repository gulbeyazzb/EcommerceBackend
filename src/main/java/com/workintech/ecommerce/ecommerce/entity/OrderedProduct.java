package com.workintech.ecommerce.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "cart", schema = "ecommerceweb")
public class OrderedProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "product_id")
    private long productId;

    @Column(name = "count")
    private int count;

    @Column(name = "detail")
    private String detail;

}

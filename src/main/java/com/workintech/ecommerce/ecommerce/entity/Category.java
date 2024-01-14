package com.workintech.ecommerce.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "categories", schema = "ecommerceweb")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "code")
    private String code;

    @Column(name = "title")
    private String title;

    @Column(name = "img")
    private String img;

    @Column(name = "rating")
    private double rating;

    @Column(name = "gender")
    @Enumerated(EnumType.STRING)
    private Gender gender;

    @OneToMany(mappedBy = "category", cascade = CascadeType.ALL)
    private List<Product> products;  //don't return

    public void addProduct(Product product){
        if(products == null){
            products = new ArrayList<>();
        }
        products.add(product);
    }


}

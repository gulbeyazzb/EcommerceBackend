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
@Table(name = "products", schema = "ecommerceweb")
public class Products {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private String price;

    @Column(name = "stock")
    private String stock;

    @Column(name = "category_id")
    private long categoryId;

    @Column(name = "rating")
    private String rating;

    @Column(name = "sell_count")
    private String sellCount;

    @Column(name = "image")
    private String image;

    @ManyToMany(cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinTable(name = "order_product",schema = "ecommerceweb",joinColumns = @JoinColumn(name = "product_id"),
            inverseJoinColumns = @JoinColumn(name = "order_id"))
    private List<Order> orders;

    public void addOrder(Order order){
        if(orders==null){
            orders=new ArrayList<>();
        }
        orders.add(order);
    }

}

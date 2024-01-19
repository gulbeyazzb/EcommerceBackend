package com.workintech.ecommerce.ecommerce.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "order", schema = "ecommerceweb")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "addres_id")
    private long addressId;

    @Column(name = "order_date")
    private String orderDate;

    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_month")
    private String cardMonth;

    @Column(name = "card_year")
    private String cardYear;

    @Column(name = "card_cvv")
    private String cardCvv;

    @Column(name = "price")
    private double price;

    @Column(name = "userName")
    private String userName;

    @Column(name = "products")
    private List<String> products;
//TODO create Orderedproducts entity,service,repo,controller. endpoint-> orderedProducts(completed on FE)
}

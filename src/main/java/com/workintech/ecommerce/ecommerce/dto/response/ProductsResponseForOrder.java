package com.workintech.ecommerce.ecommerce.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductsResponseForOrder{
    private long id;
    private int sellCount;
    private String description;
}

package com.workintech.ecommerce.ecommerce.dto.response;

import java.util.List;

public record ProductResponse(Long id, String name, String description, Double price, Integer stock, Long categoryID,
                              Double rating, Integer sellCount,String image) {
}

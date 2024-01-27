package com.workintech.ecommerce.ecommerce.dto.response;

import java.util.List;

public record ProductResponse(Long id, String name, String description, String price, String stock, Long categoryID,
                              String rating, String sellCount,String image) {
}

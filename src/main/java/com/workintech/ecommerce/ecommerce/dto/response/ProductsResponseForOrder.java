package com.workintech.ecommerce.ecommerce.dto.response;

import lombok.Data;
import lombok.NoArgsConstructor;

public record ProductsResponseForOrder(long id, String sellCount, String description) {
}

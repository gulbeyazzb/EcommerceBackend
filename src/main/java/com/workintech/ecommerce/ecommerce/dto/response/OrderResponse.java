package com.workintech.ecommerce.ecommerce.dto.response;

import java.util.List;

public record OrderResponse(long id, String cardNumber, String cardMonth, String cardYear, String cardCvv,
                            String price, long addressId, String orderDate, String userName,
                            List<ProductsResponseForOrder> products) {
}

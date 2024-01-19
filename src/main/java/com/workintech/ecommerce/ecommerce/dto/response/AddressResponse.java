package com.workintech.ecommerce.ecommerce.dto.response;

public record AddressResponse(long id,String name, String surname,String phone,
                              String city, String district, String neighborhood, String address) {
}

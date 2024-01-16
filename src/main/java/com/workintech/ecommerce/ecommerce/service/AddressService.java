package com.workintech.ecommerce.ecommerce.service;

import com.workintech.ecommerce.ecommerce.entity.Address;

import java.util.List;
import java.util.Optional;

public interface AddressService {
    Address findAddressByID(long id);
    List<Address> getAllAddress();
    String saveAddress(Address address);
}

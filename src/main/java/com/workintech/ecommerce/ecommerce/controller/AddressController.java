package com.workintech.ecommerce.ecommerce.controller;

import com.workintech.ecommerce.ecommerce.converter.Converter;
import com.workintech.ecommerce.ecommerce.dto.response.AddressResponse;
import com.workintech.ecommerce.ecommerce.entity.Address;
import com.workintech.ecommerce.ecommerce.service.AddressService;
import com.workintech.ecommerce.ecommerce.service.CardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/address")
public class AddressController {
    private AddressService addressService;

    @Autowired
    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping("/{id}")
    public AddressResponse getAddressById(@PathVariable long id){
        return Converter.findAddress(addressService.findAddressByID(id));
    }

    @PutMapping("/{id}")
    public AddressResponse updateAddress(@RequestBody Address address, @PathVariable long id){
        return null;
        //TODO update metod
    }

}

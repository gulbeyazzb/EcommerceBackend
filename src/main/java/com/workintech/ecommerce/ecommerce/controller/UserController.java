package com.workintech.ecommerce.ecommerce.controller;

import com.workintech.ecommerce.ecommerce.entity.Address;
import com.workintech.ecommerce.ecommerce.entity.User;
import com.workintech.ecommerce.ecommerce.service.AddressService;
import com.workintech.ecommerce.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    private UserService userService;
    private AddressService addressService;

    @Autowired
    public UserController(UserService userService, AddressService addressService) {
        this.userService = userService;
        this.addressService = addressService;
    }

    @PostMapping("/address")
    public String saveAddress(@RequestBody Address address){
        return addressService.saveAddress(address);
    }

    @GetMapping("/address")
    public List<Address> getAllAddress(){
        return addressService.getAllAddress();
    }
}

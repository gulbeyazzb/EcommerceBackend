package com.workintech.ecommerce.ecommerce.controller;

import com.workintech.ecommerce.ecommerce.converter.Converter;
import com.workintech.ecommerce.ecommerce.dto.request.LoginRequest;
import com.workintech.ecommerce.ecommerce.dto.request.UserRequest;
import com.workintech.ecommerce.ecommerce.dto.response.LoginResponse;
import com.workintech.ecommerce.ecommerce.dto.response.UserResponse;
import com.workintech.ecommerce.ecommerce.entity.User;
import com.workintech.ecommerce.ecommerce.service.AuthenticationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthenticationService authenticationService;

    @Autowired
    public AuthController(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }

    @PostMapping("/signup/")
    public UserResponse register(@RequestBody UserRequest userRequest){
       User user=authenticationService
                .register(userRequest.name(), userRequest.email(),
                        userRequest.password(), userRequest.role());
       return Converter.findUser(user);
    }

    @PostMapping("/login")
    public UserResponse login(@RequestBody LoginRequest loginRequest){
        return authenticationService.login(loginRequest);

    }
}

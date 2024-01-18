package com.workintech.ecommerce.ecommerce.service;

import com.workintech.ecommerce.ecommerce.entity.User;
import com.workintech.ecommerce.ecommerce.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Import;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class AuthenticationServiceTest {

    private AuthenticationService authenticationService;
    private UserRepository userRepository;

    @Autowired
    public AuthenticationServiceTest(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @Test
    @DisplayName("Can signup successfully")
    void signup() {
        User signupUser = authenticationService.signup("Maya", "maya@test.com", "12345678", "customer");
        userRepository.save(signupUser);
        assertNotNull(signupUser);
    }

    @Test
    @DisplayName("Can't signup ")
    void signupFail() {
        User signupUser = authenticationService.signup("Maya", "maya@test.com", "12345678", "customer");
        userRepository.save(signupUser);
        assertNull(signupUser);
    }

    @Test
    void login() {
    }
}
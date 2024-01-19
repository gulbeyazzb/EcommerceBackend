package com.workintech.ecommerce.ecommerce.service;

import com.workintech.ecommerce.ecommerce.entity.User;
import com.workintech.ecommerce.ecommerce.exception.CommerceException;
import com.workintech.ecommerce.ecommerce.repository.UserRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;


@SpringBootTest
@ExtendWith(MockitoExtension.class)
class AuthenticationServiceTest {

    private AuthenticationService authenticationService;
    @Mock
    private UserRepository userRepository;

    @Mock
    private UserService userService;


    @Autowired
    public AuthenticationServiceTest(AuthenticationService authenticationService) {
        this.authenticationService = authenticationService;
    }


    @Test
    @DisplayName("Can signup successfully")
    void signup() {
        User signupUser = authenticationService.signup("Maya", "maya@test.com", "12345678", "customer");
        verify(userRepository.save(signupUser));
    }

    @Test
    @DisplayName("Can't signup ")
    void signupFail() {
        User signupUser = authenticationService.signup("Maya", "maya@test.com", "12345678", "customer");
       given(userRepository.save(signupUser)).willReturn(signupUser);

       assertThatThrownBy(()-> authenticationService.signup("Maya", "maya@test.com", "12345678", "customer"))
               .isInstanceOf(CommerceException.class)
                       .hasMessageContaining("Role mustn't be empty");
        verify(userRepository, never()).save(signupUser);

    }

    @Test
    void login() {
    }
}
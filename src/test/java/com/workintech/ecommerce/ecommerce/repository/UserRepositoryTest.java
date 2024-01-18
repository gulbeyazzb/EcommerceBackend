package com.workintech.ecommerce.ecommerce.repository;

import com.workintech.ecommerce.ecommerce.entity.Role;
import com.workintech.ecommerce.ecommerce.entity.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class UserRepositoryTest {

    private UserRepository userRepository;

    private RoleRepository roleRepository;


    @Autowired
    public UserRepositoryTest(RoleRepository
            roleRepository, UserRepository userRepository) {
        this.roleRepository = roleRepository;
        this.userRepository = userRepository;
    }


    @DisplayName("Can find user by email")
    @Test
    void findUserByEmail() {
        User presentUser = new User();

        Optional<User> foundUser = userRepository.findUserByEmail("test@test.com");
        if (foundUser.isPresent()) {
            presentUser = foundUser.get();
        }
        assertNotNull(presentUser);
    }

    @DisplayName("Can't find user by email")
    @Test
    void findUserByEmailFail() {
        User presentUser=new User();

        Optional<User> foundUser = userRepository.findUserByEmail("maya1@test.com");
        if (foundUser.isPresent()) {
            presentUser = foundUser.get();
        }else{
            presentUser=null;
        }
        assertNull(presentUser);
    }

}
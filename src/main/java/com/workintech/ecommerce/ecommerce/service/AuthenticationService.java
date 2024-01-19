package com.workintech.ecommerce.ecommerce.service;

import com.workintech.ecommerce.ecommerce.converter.Converter;
import com.workintech.ecommerce.ecommerce.dto.request.LoginRequest;
import com.workintech.ecommerce.ecommerce.dto.response.UserResponse;
import com.workintech.ecommerce.ecommerce.entity.Role;
import com.workintech.ecommerce.ecommerce.entity.User;
import com.workintech.ecommerce.ecommerce.exception.CommerceException;
import com.workintech.ecommerce.ecommerce.repository.RoleRepository;
import com.workintech.ecommerce.ecommerce.repository.UserRepository;
import com.workintech.ecommerce.ecommerce.util.validations.GeneralValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class AuthenticationService {

    private UserRepository userRepository;
    private RoleRepository roleRepository;
    private PasswordEncoder passwordEncoder;

    @Autowired
    public AuthenticationService(UserRepository userRepository, RoleRepository roleRepository,
                                 PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public User signup(String name, String email, String password, String role) {
        Role userRole = new Role();
        String encodedPassword = passwordEncoder.encode(password);
        Optional<Role> optionalRole = roleRepository.findByAuthority(role);
        if (optionalRole.isPresent()) {
            userRole = optionalRole.get();
            User user = new User();
            user.setName(name);
            user.setEmail(email);
            user.setPassword(encodedPassword);
            user.setRole(userRole);
            userRepository.save(user);
            return user;

        } else {
            throw new CommerceException("Role mustn't be empty", HttpStatus.BAD_REQUEST);
        }
    }

    public UserResponse login(LoginRequest loginRequest) {
        GeneralValidation.checkEmptyOrNull(loginRequest.email(), "email ");
        GeneralValidation.checkEmptyOrNull(loginRequest.password(), "password ");
        Optional<User> optionalUser = userRepository.findUserByEmail(loginRequest.email());
        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            boolean arePasswordsMatches = passwordEncoder.matches(loginRequest.password(), user.getPassword());
            if (arePasswordsMatches) {
                return Converter.findUser(user);
            }
            throw new CommerceException("Invalid Credantials", HttpStatus.BAD_REQUEST);
        }
        throw new CommerceException("Invalid Credantials", HttpStatus.BAD_REQUEST);
    }

}

package com.workintech.ecommerce.ecommerce.service;

import com.workintech.ecommerce.ecommerce.converter.Converter;
import com.workintech.ecommerce.ecommerce.dto.response.UserResponse;
import com.workintech.ecommerce.ecommerce.entity.User;
import com.workintech.ecommerce.ecommerce.exception.CommerceException;
import com.workintech.ecommerce.ecommerce.repository.UserRepository;
import com.workintech.ecommerce.ecommerce.util.validations.GeneralValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService, UserService {

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void findUserByEmail(String email) {
        boolean userExist = userRepository.findUserByEmail(email).isPresent();
        if (userExist) {
            throw new CommerceException(GeneralValidation.IS_EMAIL_PRESENT, HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public User findUserByID(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return optionalUser.get();
        }
        throw new CommerceException(GeneralValidation.IS_USER_PRESENT, HttpStatus.NOT_FOUND);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return Converter.findUsers(userRepository.findAll());
    }

    @Override
    public UserResponse saveUser(User user) {

        GeneralValidation.checkEmptyOrNull(user.getName(), "name");
        GeneralValidation.checkEmptyOrNull(user.getEmail(), "email");
        GeneralValidation.checkEmptyOrNull(user.getPassword(), "password");
        return Converter.findUser(userRepository.save(user));
    }

    @Override
    public User deleteUser(long id) {
        User user = findUserByID(id);
        GeneralValidation.IsUserPresent(user);
        userRepository.delete(user);
        return user;
    }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(username).orElseThrow(() ->
                new UsernameNotFoundException(GeneralValidation.IS_USER_VALID));
    }
}

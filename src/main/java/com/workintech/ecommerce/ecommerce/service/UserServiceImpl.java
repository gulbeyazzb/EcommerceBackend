package com.workintech.ecommerce.ecommerce.service;

import com.workintech.ecommerce.ecommerce.converter.Converter;
import com.workintech.ecommerce.ecommerce.dto.response.UserResponse;
import com.workintech.ecommerce.ecommerce.entity.User;
import com.workintech.ecommerce.ecommerce.exception.CommerceException;
import com.workintech.ecommerce.ecommerce.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserDetailsService, UserService{

    private UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public void findUserByEmail(String email) {
        boolean userExist = userRepository.findUserByEmail(email).isPresent(); //mevcut mu?
        if(userExist){
            throw new CommerceException("Email already taken.", HttpStatus.BAD_REQUEST);
        }
    }

    @Override
    public User findUserByID(long id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if(optionalUser.isPresent()){
            return optionalUser.get();
        }
        throw new CommerceException("User not found!", HttpStatus.NOT_FOUND);
    }

    @Override
    public List<UserResponse> getAllUsers() {
        return Converter.findUsers(userRepository.findAll());
    }

    @Override
    public UserResponse saveUser(User user) {

        return Converter.findUser(userRepository.save(user));
    }

    @Override
    public User deleteUser(long id) {
        User user = findUserByID(id);
        if(user == null){
            throw new CommerceException("User not found!", HttpStatus.NOT_FOUND);
        }
        userRepository.delete(user);
        return user;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository.findUserByEmail(username).orElseThrow(() ->
                new UsernameNotFoundException("User not valid!"));
    }
}

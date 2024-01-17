package com.workintech.ecommerce.ecommerce.service;

import com.workintech.ecommerce.ecommerce.dto.response.UserResponse;
import com.workintech.ecommerce.ecommerce.entity.User;

import java.util.List;

public interface UserService {
        void findUserByEmail(String email);
        User findUserByID(long id);
        List<UserResponse> getAllUsers();
        UserResponse saveUser(User user);
        User deleteUser(long id);
}

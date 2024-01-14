package com.workintech.ecommerce.ecommerce.service;

import com.workintech.ecommerce.ecommerce.dto.response.UserResponse;
import com.workintech.ecommerce.ecommerce.entity.Address;
import com.workintech.ecommerce.ecommerce.entity.BillingAddress;
import com.workintech.ecommerce.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserService {
        void findUserByEmail(String email);
        User findUserByID(long id);
        List<UserResponse> getAllUsers();
        UserResponse saveUser(User user);
        User deleteUser(long id);
}

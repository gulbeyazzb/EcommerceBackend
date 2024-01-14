package com.workintech.ecommerce.ecommerce.converter;

import com.workintech.ecommerce.ecommerce.dto.response.CategoryResponse;
import com.workintech.ecommerce.ecommerce.dto.response.RoleResponse;
import com.workintech.ecommerce.ecommerce.dto.response.UserResponse;
import com.workintech.ecommerce.ecommerce.entity.Category;
import com.workintech.ecommerce.ecommerce.entity.Role;
import com.workintech.ecommerce.ecommerce.entity.User;

import java.util.ArrayList;
import java.util.List;

public class Converter {

    //ROLES
    public static List<RoleResponse> findRoles(List<Role> roles){
        List<RoleResponse> responses = new ArrayList<>();

        for(Role role: roles){
            responses.add(new RoleResponse(role.getId(),role.getAuthority()));
        }
        return responses;
    }

    //USERS
    public static List<UserResponse> findUsers(List<User> users){
        List<UserResponse> userResponses = new ArrayList<>();

        for(User user: users){
            userResponses.add(new UserResponse(user.getId(), user.getName(),user.getEmail()));
        }
        return userResponses;
    }
    public static UserResponse findUser(User user){
        return new UserResponse(user.getId(), user.getName(),user.getEmail());
    }

    public static List<CategoryResponse> findCategories(List<Category> categories){
        List<CategoryResponse> categoryResponses = new ArrayList<>();

        for(Category category: categories){
            categoryResponses.add(new CategoryResponse(category.getId(),category.getCode(),
                    category.getTitle(), category.getImg(), category.getRating(),category.getGender()));
        }
        return categoryResponses;
    }
    public static CategoryResponse findCategory(Category category){
        return new CategoryResponse(category.getId(),category.getCode(),
                category.getTitle(), category.getImg(), category.getRating(),category.getGender());
    }

}

package com.workintech.ecommerce.ecommerce.service;

import com.workintech.ecommerce.ecommerce.dto.response.RoleResponse;
import com.workintech.ecommerce.ecommerce.entity.Role;

import java.util.List;

public interface RoleService {
    List<Role> getRoles();
}

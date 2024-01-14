package com.workintech.ecommerce.ecommerce.dto.response;

import com.workintech.ecommerce.ecommerce.entity.Gender;
import org.springframework.data.jpa.repository.JpaRepository;

public record CategoryResponse(Long id,String code,String title, String img,Double rating, Gender gender){
}

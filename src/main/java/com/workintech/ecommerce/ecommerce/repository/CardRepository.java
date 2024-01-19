package com.workintech.ecommerce.ecommerce.repository;

import com.workintech.ecommerce.ecommerce.entity.Card;
import com.workintech.ecommerce.ecommerce.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CardRepository extends JpaRepository<Card,Long> {
    @Query(value = "SELECT * FROM ecommerceweb.card AS c WHERE c.id = :cardId",nativeQuery = true)
    Card getCardById(long cardId);
}

package com.workintech.ecommerce.ecommerce.repository;

import com.workintech.ecommerce.ecommerce.entity.BillingAddress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;


public interface BillingAddressRepository extends JpaRepository<BillingAddress, Long> {
    @Query(value = "SELECT * FROM ecommerce.billing_address AS b WHERE b.id = :id",nativeQuery = true)
    Optional<BillingAddress> findAddressByID(long id);
}

package com.workintech.ecommerce.ecommerce.repository;

import com.workintech.ecommerce.ecommerce.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;


//Transaction işlemi bir veya birden fazla sorguların(SQL)
// aynı süreçte işlem görmesidir.Bu sayede eğer istenmeyen
// bir durum oluştuğunda bütün bu süreci geri alabiliriz(rollback),
// yada hepsi aynı anda onaylayabiliriz
@Transactional(readOnly = true) //Hangi veritabanını kullandığınıza bağlı olarak,
// tablo kilitlerini atlayabilir veya yanlışlıkla tetikleyebileceğiniz yazma işlemlerini bile reddedebilir.
public interface UserRepository extends JpaRepository<User,Long> {
    @Query("SELECT u FROM User u WHERE u.email = :email")
    Optional<User> findUserByEmail(String email);

}
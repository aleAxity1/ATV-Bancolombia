package com.axity.office.persistence;


import com.axity.office.model.ProductByUser;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductByUserRepository extends JpaRepository<ProductByUser, Long> {

    @Query("SELECT u FROM ProductByUser u WHERE u.xpuser = :userId ORDER BY u.xpid ASC NULLS LAST")
    List<ProductByUser> findAllByUser(@Param("userId") String userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM ProductByUser u WHERE u.xpuser = :userId AND u.xpcopr = :productId")
    void deleteByUserAndProduct(@Param("userId") String userId, @Param("productId") String productId);

}
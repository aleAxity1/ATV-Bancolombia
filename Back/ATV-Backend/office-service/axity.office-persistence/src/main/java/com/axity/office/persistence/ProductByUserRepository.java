package com.axity.office.persistence;

import com.axity.office.model.ProductByUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductByUserRepository extends JpaRepository<ProductByUser, Long> {
}
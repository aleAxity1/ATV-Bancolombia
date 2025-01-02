package com.axity.office.persistence;

import com.axity.office.model.ProductByUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductByUserRepository extends JpaRepository<ProductByUser, String> {
}
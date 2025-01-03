package com.axity.office.persistence;

import com.axity.office.model.AccessByUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessByUserRepository extends JpaRepository<AccessByUser, Integer> {
}
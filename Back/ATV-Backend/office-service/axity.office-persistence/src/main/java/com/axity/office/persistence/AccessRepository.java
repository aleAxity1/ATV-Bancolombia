package com.axity.office.persistence;

import com.axity.office.model.Access;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AccessRepository extends JpaRepository<Access, Integer> {
}
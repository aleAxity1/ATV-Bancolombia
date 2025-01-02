package com.axity.office.persistence;

import com.axity.office.model.Domain;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomainRepository extends JpaRepository<Domain, String> {
}
package com.axity.office.persistence;

import com.axity.office.model.Frequency;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface FrequencyPersistence extends JpaRepository<Frequency, Long> {
    @Query("SELECT u FROM Frequency u WHERE u.fxcopr = :productId and  u.fxcodo = :documentId")
    Optional<Frequency> findAllByProductDocument(@Param("productId") String productId, @Param("documentId") String documentId);
}
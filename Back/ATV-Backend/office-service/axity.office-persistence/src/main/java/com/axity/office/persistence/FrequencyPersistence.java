package com.axity.office.persistence;

import com.axity.office.model.Frequency;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FrequencyPersistence extends JpaRepository<Frequency, Long> {
}
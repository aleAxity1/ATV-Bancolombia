package com.axity.office.persistence;

import com.axity.office.model.BranchByUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BranchByUserRepository extends JpaRepository<BranchByUser, Long> {
}
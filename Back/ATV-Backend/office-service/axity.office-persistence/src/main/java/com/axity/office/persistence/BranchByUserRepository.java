package com.axity.office.persistence;

import com.axity.office.model.BranchByUser;

import jakarta.transaction.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchByUserRepository extends JpaRepository<BranchByUser, Long> {

    @Query("SELECT u FROM BranchByUser u WHERE u.xsuser = :userId ORDER BY u.xsid ASC NULLS LAST")
    List<BranchByUser> findAllByUser(@Param("userId") String userId);

    @Modifying
    @Transactional
    @Query("DELETE FROM BranchByUser u WHERE u.xsuser = :userId AND u.xscosu = :branchId")
    void deleteByUserAndBranch(@Param("userId") String userId, @Param("branchId") Short branchId);
}
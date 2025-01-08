package com.axity.office.persistence;

import com.axity.office.model.BranchByUser;
import com.axity.office.model.ProductByUser;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface BranchByUserRepository extends JpaRepository<BranchByUser, Long> {

    @Query("SELECT u FROM BranchByUser u WHERE u.xsuser = :user ORDER BY u.xsid ASC NULLS LAST")
    List<BranchByUser> findAllByUser(@Param("user") String user);

}
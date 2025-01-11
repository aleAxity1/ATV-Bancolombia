package com.axity.office.persistence;


import com.axity.office.model.ProductDocumentByBranch;

import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDocumentByBranchPersistence extends JpaRepository<ProductDocumentByBranch, Long> {

    @Query("SELECT u FROM ProductDocumentByBranch u WHERE u.xscopr = :productId and  u.xscodo = :documentId")
    Page<ProductDocumentByBranch> findAllByProductDocument(Pageable pageable, @Param("productId") String productId, @Param("documentId") String documentId);

    @Query("SELECT u FROM ProductDocumentByBranch u WHERE u.xscopr = :productId and  u.xscodo = :documentId")
    List<ProductDocumentByBranch> findAllByProductDocument(@Param("productId") String productId, @Param("documentId") String documentId);

    @Query("SELECT u FROM ProductDocumentByBranch u WHERE u.xscopr = :productId and  u.xscodo = :documentId and  u.xscosu = :branchId")
    Optional<ProductDocumentByBranch> findAllByProductDocumentAndBranch(@Param("productId") String productId, @Param("documentId") String documentId, @Param("branchId") Short branchId);

    @Modifying
    @Transactional
    @Query("DELETE FROM ProductDocumentByBranch u WHERE u.xscopr= :productId AND u.xscodo = :documentId  AND u.xscosu = :branchId")
    void deleteByProductDocument(@Param("productId") String productId, @Param("documentId") String documentId, @Param("branchId") Short branchId);


}
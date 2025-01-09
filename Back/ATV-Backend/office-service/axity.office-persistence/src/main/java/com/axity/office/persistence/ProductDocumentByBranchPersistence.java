package com.axity.office.persistence;

import com.axity.office.model.ProductDocumentByBranch;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDocumentByBranchPersistence extends JpaRepository<ProductDocumentByBranch, Long> {
}
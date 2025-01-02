package com.axity.office.persistence;

import com.axity.office.model.ProductDocument;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductDocumentRepository extends JpaRepository<ProductDocument, String> {
}
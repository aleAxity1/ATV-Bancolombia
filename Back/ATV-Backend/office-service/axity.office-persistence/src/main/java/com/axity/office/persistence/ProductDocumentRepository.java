package com.axity.office.persistence;


import com.axity.office.model.ProductDocument;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDocumentRepository extends JpaRepository<ProductDocument, Integer> {
}
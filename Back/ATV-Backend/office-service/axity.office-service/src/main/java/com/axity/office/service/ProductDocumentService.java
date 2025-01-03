package com.axity.office.service;

import com.axity.office.commons.dto.ProductDocumentDTO;

import java.util.List;

public interface ProductDocumentService {
    ProductDocumentDTO createProductDocument(ProductDocumentDTO productDocumentDTO);
    List<ProductDocumentDTO> getAllProductDocuments();
    ProductDocumentDTO getProductDocumentById(String id);
    ProductDocumentDTO updateProductDocument(ProductDocumentDTO productDocumentDTO);
    void deleteProductDocument(String id);
}
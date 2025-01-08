package com.axity.office.service.impl;

import com.axity.office.commons.dto.ProductDocumentDTO;
import com.axity.office.model.ProductDocument;
import com.axity.office.persistence.ProductDocumentRepository;
import com.axity.office.service.ProductDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductDocumentServiceImpl implements ProductDocumentService {

    @Autowired
    private ProductDocumentRepository productDocumentRepository;

    @Override
    public ProductDocumentDTO createProductDocument(ProductDocumentDTO productDocumentDTO) {
        ProductDocument productDocument = new ProductDocument();
        // Map DTO to Entity
        productDocument.setXpcopr(productDocumentDTO.getXpcopr());
        productDocument.setXpcodo(productDocumentDTO.getXpcodo());
        productDocument.setXpdsdo(productDocumentDTO.getXpdsdo());
        productDocument.setXpcta(productDocumentDTO.getXpcta());
        productDocument.setXpstdo(productDocumentDTO.getXpstdo());
        productDocument.setXpfeca(productDocumentDTO.getXpfeca());

        productDocument = productDocumentRepository.save(productDocument);

        // Map Entity to DTO
        return mapToDTO(productDocument);
    }

    @Override
    public List<ProductDocumentDTO> getAllProductDocuments() {
        return productDocumentRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public ProductDocumentDTO getProductDocumentById(Integer id) {
        return productDocumentRepository.findById(id).map(this::mapToDTO).orElse(null);
    }

    @Override
    public ProductDocumentDTO updateProductDocument(ProductDocumentDTO productDocumentDTO) {
        ProductDocument productDocument = productDocumentRepository.findById(productDocumentDTO.getXpid()).orElse(null);
        if (productDocument != null) {
            // Update fields
            productDocument.setXpdsdo(productDocumentDTO.getXpdsdo());
            productDocument.setXpcta(productDocumentDTO.getXpcta());
            productDocument.setXpstdo(productDocumentDTO.getXpstdo());
            productDocument.setXpfeca(productDocumentDTO.getXpfeca());

            productDocument = productDocumentRepository.save(productDocument);
        }
        return mapToDTO(productDocument);
    }

    @Override
    public void deleteProductDocument(Integer id) {
        productDocumentRepository.deleteById(id);
    }

    private ProductDocumentDTO mapToDTO(ProductDocument productDocument) {
        ProductDocumentDTO dto = new ProductDocumentDTO();
        dto.setXpcopr(productDocument.getXpcopr());
        dto.setXpcodo(productDocument.getXpcodo());
        dto.setXpdsdo(productDocument.getXpdsdo());
        dto.setXpcta(productDocument.getXpcta());
        dto.setXpstdo(productDocument.getXpstdo());
        dto.setXpfeca(productDocument.getXpfeca());
        return dto;
    }
}
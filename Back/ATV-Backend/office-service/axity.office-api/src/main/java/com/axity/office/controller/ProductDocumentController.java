package com.axity.office.controller;

import com.axity.office.commons.dto.ProductDocumentDTO;
import com.axity.office.facade.ProductDocumentFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productdocument")
public class ProductDocumentController {

    @Autowired
    private ProductDocumentFacade productDocumentFacade;

    @PostMapping
    public ResponseEntity<ProductDocumentDTO> createProductDocument(@RequestBody ProductDocumentDTO productDocumentDTO) {
        return ResponseEntity.ok(productDocumentFacade.createProductDocument(productDocumentDTO));
    }

    @GetMapping
    public ResponseEntity<List<ProductDocumentDTO>> getAllProductDocuments() {
        return ResponseEntity.ok(productDocumentFacade.getAllProductDocuments());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDocumentDTO> getProductDocumentById(@PathVariable Long id) {
        return ResponseEntity.ok(productDocumentFacade.getProductDocumentById(id));
    }

    @PutMapping
    public ResponseEntity<ProductDocumentDTO> updateProductDocument(@RequestBody ProductDocumentDTO productDocumentDTO) {
        return ResponseEntity.ok(productDocumentFacade.updateProductDocument(productDocumentDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductDocument(@PathVariable Long id) {
        productDocumentFacade.deleteProductDocument(id);
        return ResponseEntity.noContent().build();
    }
}
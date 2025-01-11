package com.axity.office.controller;

import com.axity.office.commons.dto.ProductDocumentByBranchDto;
import com.axity.office.facade.ProductDocumentByBranchFacade;
import com.axity.office.commons.response.GenericResponseDto;
import com.axity.office.commons.response.PaginatedResponseDto;
import com.axity.office.commons.request.PaginatedRequestDto;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/productdocumentbybranch")
public class ProductDocumentByBranchController {

    @Autowired
    private ProductDocumentByBranchFacade productDocumentByBranchFacade;

    @GetMapping("")
    public ResponseEntity<PaginatedResponseDto<ProductDocumentByBranchDto>> findProductDocumentByBranches(
            @RequestParam(defaultValue = "50") int limit,
            @RequestParam(defaultValue = "0") int offset) {
        return ResponseEntity.ok(this.productDocumentByBranchFacade.findProductDocumentByBranches(new PaginatedRequestDto(limit, offset)));
    }

    @GetMapping("/{productId}/{documentId}")
    public ResponseEntity<PaginatedResponseDto<ProductDocumentByBranchDto>> findByProductDocumentAndBranch(
            @RequestParam(defaultValue = "50") int limit,
            @RequestParam(defaultValue = "0") int offset,
            @PathVariable String productId, @PathVariable String documentId) {
        return ResponseEntity.ok(this.productDocumentByBranchFacade.findByProductDocument(new PaginatedRequestDto(limit, offset), productId, documentId));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GenericResponseDto<ProductDocumentByBranchDto>> findProductDocumentByBranch(@PathVariable Long id) {
        var result = this.productDocumentByBranchFacade.find(id);
        return new ResponseEntity<>(result, result == null ? HttpStatus.NO_CONTENT : HttpStatus.OK);
    }

    @PostMapping("")
    public ResponseEntity<GenericResponseDto<ProductDocumentByBranchDto>> create(@RequestBody ProductDocumentByBranchDto dto) {
        return new ResponseEntity<>(this.productDocumentByBranchFacade.create(dto), HttpStatus.CREATED);
    }

    @PutMapping("/{productId}/{documentId}")
    public ResponseEntity<GenericResponseDto<Boolean>> update(@PathVariable String productId, @PathVariable String documentId, @RequestBody List<Short> branches) {
        return ResponseEntity.ok(this.productDocumentByBranchFacade.updateByProductDocument(productId, documentId, branches));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<GenericResponseDto<Boolean>> delete(@PathVariable Long id) {
        return ResponseEntity.ok(this.productDocumentByBranchFacade.delete(id));
    }

    @GetMapping("/ping")
    public ResponseEntity<GenericResponseDto<String>> ping() {
        return ResponseEntity.ok(new GenericResponseDto<>("pong"));
    }
}
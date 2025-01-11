package com.axity.office.facade.impl;

import com.axity.office.commons.dto.ProductDocumentByBranchDto;
import com.axity.office.commons.response.GenericResponseDto;
import com.axity.office.commons.response.PaginatedResponseDto;
import com.axity.office.commons.request.PaginatedRequestDto;
import com.axity.office.facade.ProductDocumentByBranchFacade;
import com.axity.office.service.ProductDocumentByBranchService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ProductDocumentByBranchFacadeImpl implements ProductDocumentByBranchFacade {

    @Autowired
    private ProductDocumentByBranchService productDocumentByBranchService;

    @Override
    public PaginatedResponseDto<ProductDocumentByBranchDto> findProductDocumentByBranches(PaginatedRequestDto request) {
        return productDocumentByBranchService.findProductDocumentByBranches(request);
    }

    @Override
    public GenericResponseDto<ProductDocumentByBranchDto> find(Long id) {
        return productDocumentByBranchService.find(id);
    }

    @Override
    public GenericResponseDto<ProductDocumentByBranchDto> create(ProductDocumentByBranchDto dto) {
        return productDocumentByBranchService.create(dto);
    }

    @Override
    public GenericResponseDto<Boolean> update(ProductDocumentByBranchDto dto) {
        return productDocumentByBranchService.update(dto);
    }

    @Override
    public GenericResponseDto<Boolean> delete(Long id) {
        return productDocumentByBranchService.delete(id);
    }

    @Override
    public PaginatedResponseDto<ProductDocumentByBranchDto> findByProductDocument(PaginatedRequestDto request,
            String productId, String documentId) {
    
        return productDocumentByBranchService.findByProductDocument(request, productId, documentId);
    }

    @Override
    public GenericResponseDto<ProductDocumentByBranchDto> findByProductDocumentAndBranch(String productId,
            String documentId, Short branchId) {

        return productDocumentByBranchService.findByProductDocumentAndBranch(productId, documentId, branchId);
    }

    @Override
    public GenericResponseDto<Boolean> updateByProductDocument(String productId, String documentId,
            List<Short> branches) {
        return productDocumentByBranchService.updateByProductDocument(productId, documentId, branches);
    }
}
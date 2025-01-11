package com.axity.office.service;

import java.util.List;

import com.axity.office.commons.dto.ProductDocumentByBranchDto;
import com.axity.office.commons.response.GenericResponseDto;
import com.axity.office.commons.response.PaginatedResponseDto;
import com.axity.office.commons.request.PaginatedRequestDto;

public interface ProductDocumentByBranchService {
    PaginatedResponseDto<ProductDocumentByBranchDto> findProductDocumentByBranches(PaginatedRequestDto request);
    GenericResponseDto<ProductDocumentByBranchDto> find(Long id);
    GenericResponseDto<ProductDocumentByBranchDto> create(ProductDocumentByBranchDto dto);
    GenericResponseDto<Boolean> update(ProductDocumentByBranchDto dto);
    GenericResponseDto<Boolean> delete(Long id);
    PaginatedResponseDto<ProductDocumentByBranchDto> findByProductDocument(PaginatedRequestDto request, String productId,  String documentId);
    GenericResponseDto<ProductDocumentByBranchDto> findByProductDocumentAndBranch(String productId,  String documentId, Short branchId);
    GenericResponseDto<Boolean> updateByProductDocument(String productId, String documentId, List<Short> branches);
}
package com.axity.office.facade;

import com.axity.office.commons.response.GenericResponseDto;
import com.axity.office.commons.response.PaginatedResponseDto;
import com.axity.office.commons.dto.ProductDocumentByBranchDto;
import com.axity.office.commons.request.PaginatedRequestDto;

public interface ProductDocumentByBranchFacade {
    PaginatedResponseDto<ProductDocumentByBranchDto> findProductDocumentByBranches(PaginatedRequestDto request);
    GenericResponseDto<ProductDocumentByBranchDto> find(Long id);
    GenericResponseDto<ProductDocumentByBranchDto> create(ProductDocumentByBranchDto dto);
    GenericResponseDto<Boolean> update(ProductDocumentByBranchDto dto);
    GenericResponseDto<Boolean> delete(Long  id);
}
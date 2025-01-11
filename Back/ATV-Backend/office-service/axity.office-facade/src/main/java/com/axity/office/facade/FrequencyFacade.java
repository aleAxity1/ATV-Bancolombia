package com.axity.office.facade;

import com.axity.office.commons.dto.FrequencyDto;
import com.axity.office.commons.response.GenericResponseDto;
import com.axity.office.commons.request.PaginatedRequestDto;
import com.axity.office.commons.response.PaginatedResponseDto;

public interface FrequencyFacade {
    PaginatedResponseDto<FrequencyDto> findFrequencies(PaginatedRequestDto request);
    GenericResponseDto<FrequencyDto> find(Long id);
    GenericResponseDto<FrequencyDto> create(FrequencyDto dto);
    GenericResponseDto<Boolean> update(FrequencyDto dto);
    GenericResponseDto<Boolean> delete(Long id);
    GenericResponseDto<FrequencyDto> findByProductDocument(String productId, String documentId);
}
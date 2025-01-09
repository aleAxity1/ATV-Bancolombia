package com.axity.office.facade.impl;

import com.axity.office.commons.dto.FrequencyDto;
import com.axity.office.commons.response.GenericResponseDto;
import com.axity.office.commons.request.PaginatedRequestDto;
import com.axity.office.commons.response.PaginatedResponseDto;
import com.axity.office.facade.FrequencyFacade;
import com.axity.office.service.FrequencyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class FrequencyFacadeImpl implements FrequencyFacade {

    @Autowired
    private FrequencyService frequencyService;

    @Override
    public PaginatedResponseDto<FrequencyDto> findFrequencies(PaginatedRequestDto request) {
        return frequencyService.findFrequencies(request);
    }

    @Override
    public GenericResponseDto<FrequencyDto> find(Long id) {
        return frequencyService.find(id);
    }

    @Override
    public GenericResponseDto<FrequencyDto> create(FrequencyDto dto) {
        return frequencyService.create(dto);
    }

    @Override
    public GenericResponseDto<Boolean> update(FrequencyDto dto) {
        return frequencyService.update(dto);
    }

    @Override
    public GenericResponseDto<Boolean> delete(Long id) {
        return frequencyService.delete(id);
    }
}
package com.axity.office.service.impl;

import com.axity.office.commons.dto.FrequencyDto;
import com.axity.office.commons.response.GenericResponseDto;
import com.axity.office.commons.request.PaginatedRequestDto;
import com.axity.office.commons.response.PaginatedResponseDto;

import com.axity.office.model.Frequency;
import com.axity.office.persistence.FrequencyPersistence;
import com.axity.office.service.FrequencyService;
import com.github.dozermapper.core.Mapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;


@Service
public class FrequencyServiceImpl implements FrequencyService {

    @Autowired
    private FrequencyPersistence frequencyPersistence;

    @Autowired
    private Mapper mapper;

    @Override
    public PaginatedResponseDto<FrequencyDto> findFrequencies(PaginatedRequestDto request) {
        int page = request.getOffset() / request.getLimit();
        Pageable pageRequest = PageRequest.of(page, request.getLimit(), Sort.by("fxid"));

        var paged = this.frequencyPersistence.findAll(pageRequest);

        var result = new PaginatedResponseDto<FrequencyDto>(page, request.getLimit(), paged.getTotalElements());

        paged.stream().forEach(x -> result.getData().add(this.transform(x)));

        return result;
    }

    @Override
    public GenericResponseDto<FrequencyDto> find(Long id) {
        GenericResponseDto<FrequencyDto> response = null;

        var optional = this.frequencyPersistence.findById(id);
        if (optional.isPresent()) {
            response = new GenericResponseDto<>();
            response.setBody(this.transform(optional.get()));
        }

        return response;
    }

    @Override
    public GenericResponseDto<FrequencyDto> findByProductDocument(String productId, String documentId) {
        GenericResponseDto<FrequencyDto> response = null;
        var optional = this.frequencyPersistence.findAllByProductDocument(productId, documentId);
        if (optional.isPresent()) {
            response = new GenericResponseDto<>();
            response.setBody(this.transform(optional.get()));
        }
        return response;
    }


    @Override
    public GenericResponseDto<FrequencyDto> create(FrequencyDto dto) {
        Frequency entity = this.mapper.map(dto, Frequency.class);
        entity = this.frequencyPersistence.save(entity);
        return new GenericResponseDto<>(this.transform(entity));
    }

    @Override
    public GenericResponseDto<Boolean> update(FrequencyDto dto) {
        Frequency entity = this.mapper.map(dto, Frequency.class);
        this.frequencyPersistence.save(entity);
        return new GenericResponseDto<>(true);
    }

    @Override
    public GenericResponseDto<Boolean> delete(Long id) {
        this.frequencyPersistence.deleteById(id);
        return new GenericResponseDto<>(true);
    }

    private FrequencyDto transform(Frequency entity) {
        return this.mapper.map(entity, FrequencyDto.class);
    }
}
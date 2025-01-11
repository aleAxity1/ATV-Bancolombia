package com.axity.office.service.impl;

import com.axity.office.commons.dto.ProductByUserDTO;
import com.axity.office.commons.dto.ProductDocumentByBranchDto;
import com.axity.office.commons.response.GenericResponseDto;
import com.axity.office.commons.response.PaginatedResponseDto;
import com.axity.office.commons.request.PaginatedRequestDto;
import com.axity.office.model.BranchByUser;
import com.axity.office.model.ProductByUser;
import com.axity.office.model.ProductDocumentByBranch;
import com.axity.office.persistence.ProductDocumentByBranchPersistence;
import com.axity.office.service.ProductDocumentByBranchService;
import com.github.dozermapper.core.Mapper;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import org.springframework.stereotype.Service;

@Service
public class ProductDocumentByBranchServiceImpl implements ProductDocumentByBranchService {

    @Autowired
    private ProductDocumentByBranchPersistence productDocumentByBranchPersistence;

    @Autowired
    private Mapper mapper;

    @Override
    public PaginatedResponseDto<ProductDocumentByBranchDto> findProductDocumentByBranches(PaginatedRequestDto request) {
        int page = request.getOffset() / request.getLimit();
        Pageable pageRequest = PageRequest.of(page, request.getLimit(), Sort.by("xsid"));

        var paged = this.productDocumentByBranchPersistence.findAll(pageRequest);

        var result = new PaginatedResponseDto<ProductDocumentByBranchDto>(page, request.getLimit(), paged.getTotalElements());

        paged.stream().forEach(x -> result.getData().add(this.transform(x)));

        return result;
    }

    @Override
    public GenericResponseDto<ProductDocumentByBranchDto> find(Long id) {
        GenericResponseDto<ProductDocumentByBranchDto> response = null;

        var optional = this.productDocumentByBranchPersistence.findById(id);
        if (optional.isPresent()) {
            response = new GenericResponseDto<>();
            response.setBody(this.transform(optional.get()));
        }

        return response;
    }

    @Override
    public PaginatedResponseDto<ProductDocumentByBranchDto> findByProductDocument(PaginatedRequestDto request, String productId,  String documentId) {
        int page = request.getOffset() / request.getLimit();
        Pageable pageRequest = PageRequest.of(page, request.getLimit(), Sort.by("xsid"));

        var paged = this.productDocumentByBranchPersistence.findAllByProductDocument(pageRequest, productId, documentId);

        var result = new PaginatedResponseDto<ProductDocumentByBranchDto>(page, request.getLimit(), paged.getTotalElements());

        paged.stream().forEach(x -> result.getData().add(this.transform(x)));

        return result;
    }

    @Override
    public GenericResponseDto<ProductDocumentByBranchDto> findByProductDocumentAndBranch(String productId,  String documentId, Short branchId) {
        GenericResponseDto<ProductDocumentByBranchDto> response = null;

        var optional = this.productDocumentByBranchPersistence.findAllByProductDocumentAndBranch(productId, documentId, branchId);
        if (optional.isPresent()) {
            response = new GenericResponseDto<>();
            response.setBody(this.transform(optional.get()));
        }

        return response;
    }

    @Override
    public GenericResponseDto<ProductDocumentByBranchDto> create(ProductDocumentByBranchDto dto) {
        var entity = this.mapper.map(dto, ProductDocumentByBranch.class);
        var savedEntity = this.productDocumentByBranchPersistence.save(entity);
        return new GenericResponseDto<>(this.transform(savedEntity));
    }

    @Override
    public GenericResponseDto<Boolean> update(ProductDocumentByBranchDto dto) {
        var entity = this.mapper.map(dto, ProductDocumentByBranch.class);
        this.productDocumentByBranchPersistence.save(entity);
        return new GenericResponseDto<>(true);
    }

    @Override
    public GenericResponseDto<Boolean> delete(Long id) {
        this.productDocumentByBranchPersistence.deleteById(id);
        return new GenericResponseDto<>(true);
    }

    @Override
    public GenericResponseDto<Boolean> updateByProductDocument(String productId, String documentId, List<Short> branches) {    

        List<ProductDocumentByBranch> currentList = productDocumentByBranchPersistence.findAllByProductDocument(productId, documentId);
        if(!currentList.isEmpty() && currentList.size() > 0)
        {
            List<ProductDocumentByBranch> objectsToRemove = currentList.stream()
                .filter(productDocumentByBranch -> !branches.contains(productDocumentByBranch.getXscosu()))
                .collect(Collectors.toList());

            objectsToRemove.forEach(productDocumentByBranch->{
                productDocumentByBranchPersistence.deleteByProductDocument(productDocumentByBranch.getXscopr(), productDocumentByBranch.getXscodo(), productDocumentByBranch.getXscosu());
            });
        }

        if(!branches.isEmpty() && branches.size() > 0)
        {
            List<ProductDocumentByBranch> objectsToInsert = branches.stream()
                .filter(id -> !currentList.stream().anyMatch(b -> b.getXscosu() == id.shortValue()))
                .map(id -> {
                    ProductDocumentByBranch newEntity = new ProductDocumentByBranch();
                    newEntity.setXscosu(id);
                    newEntity.setXscopr(productId);
                    newEntity.setXscodo(documentId);
                    return newEntity;
                })
                .collect(Collectors.toList());

            objectsToInsert.forEach(productDocumentByBranch->{
                productDocumentByBranchPersistence.save(productDocumentByBranch);
            });
        }
        return new GenericResponseDto<>(true);
    }


    private ProductDocumentByBranchDto transform(ProductDocumentByBranch entity) {
        return this.mapper.map(entity, ProductDocumentByBranchDto.class);
    }
}
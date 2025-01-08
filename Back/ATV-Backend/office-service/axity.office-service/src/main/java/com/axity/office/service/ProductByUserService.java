package com.axity.office.service;

import com.axity.office.commons.dto.ProductByUserDTO;
import com.axity.office.model.ProductByUser;

import java.util.List;

import org.springframework.data.repository.query.Param;

public interface ProductByUserService {
    ProductByUserDTO createProductByUser(ProductByUserDTO productByUserDTO);
    List<ProductByUserDTO> getAllProductByUsers();
    ProductByUserDTO getProductByUserById(Long id);
    ProductByUserDTO updateProductByUser(ProductByUserDTO productByUserDTO);
    void deleteProductByUser(Long id);
}
package com.axity.office.service;

import com.axity.office.commons.dto.ProductByUserDTO;

import java.util.List;

public interface ProductByUserService {
    ProductByUserDTO createProductByUser(ProductByUserDTO productByUserDTO);
    List<ProductByUserDTO> getAllProductByUsers();
    ProductByUserDTO getProductByUserById(String id);
    ProductByUserDTO updateProductByUser(ProductByUserDTO productByUserDTO);
    void deleteProductByUser(String id);
}
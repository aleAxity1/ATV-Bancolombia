package com.axity.office.facade;

import com.axity.office.commons.dto.ProductByUserDTO;

import java.util.List;

public interface ProductByUserFacade {
    ProductByUserDTO createProductByUser(ProductByUserDTO productByUserDTO);
    List<ProductByUserDTO> getAllProductByUsers();
    ProductByUserDTO getProductByUserById(Long id);
    ProductByUserDTO updateProductByUser(ProductByUserDTO productByUserDTO);
    void deleteProductByUser(Long id);
}
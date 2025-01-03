package com.axity.office.facade.impl;

import com.axity.office.commons.dto.ProductByUserDTO;
import com.axity.office.facade.ProductByUserFacade;
import com.axity.office.service.ProductByUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductByUserFacadeImpl implements ProductByUserFacade {

    @Autowired
    private ProductByUserService productByUserService;

    @Override
    public ProductByUserDTO createProductByUser(ProductByUserDTO productByUserDTO) {
        return productByUserService.createProductByUser(productByUserDTO);
    }

    @Override
    public List<ProductByUserDTO> getAllProductByUsers() {
        return productByUserService.getAllProductByUsers();
    }

    @Override
    public ProductByUserDTO getProductByUserById(String id) {
        return productByUserService.getProductByUserById(id);
    }

    @Override
    public ProductByUserDTO updateProductByUser(ProductByUserDTO productByUserDTO) {
        return productByUserService.updateProductByUser(productByUserDTO);
    }

    @Override
    public void deleteProductByUser(String id) {
        productByUserService.deleteProductByUser(id);
    }
}
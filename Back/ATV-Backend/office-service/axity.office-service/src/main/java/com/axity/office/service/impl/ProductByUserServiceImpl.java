package com.axity.office.service.impl;

import com.axity.office.commons.dto.ProductByUserDTO;
import com.axity.office.model.ProductByUser;
import com.axity.office.persistence.ProductByUserRepository;
import com.axity.office.service.ProductByUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductByUserServiceImpl implements ProductByUserService {

    @Autowired
    private ProductByUserRepository productByUserRepository;

    @Override
    public ProductByUserDTO createProductByUser(ProductByUserDTO productByUserDTO) {
        ProductByUser productByUser = new ProductByUser();
        productByUser.setXpuser(productByUserDTO.getXpuser());
        productByUser.setXpcopr(productByUserDTO.getXpcopr());
        productByUserRepository.save(productByUser);
        return productByUserDTO; 
    }

    @Override
    public List<ProductByUserDTO> getAllProductByUsers() {
        return productByUserRepository.findAll().stream().map(productByUser -> {
            ProductByUserDTO dto = new ProductByUserDTO();
            dto.setXpid(productByUser.getXpid());
            dto.setXpuser(productByUser.getXpuser());
            dto.setXpcopr(productByUser.getXpcopr());
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public ProductByUserDTO getProductByUserById(Long id) {
        return productByUserRepository.findById(id).map(productByUser -> {
            ProductByUserDTO dto = new ProductByUserDTO();
            dto.setXpid(productByUser.getXpid());
            dto.setXpuser(productByUser.getXpuser());
            dto.setXpcopr(productByUser.getXpcopr());
            return dto;
        }).orElse(null);
    }

    @Override
    public ProductByUserDTO updateProductByUser(ProductByUserDTO productByUserDTO) {
        ProductByUser productByUser = productByUserRepository.findById(productByUserDTO.getXpid()).orElse(null);
        if (productByUser != null) {
            productByUser.setXpuser(productByUserDTO.getXpuser());
            productByUser.setXpcopr(productByUserDTO.getXpcopr());
            productByUserRepository.save(productByUser);
        }
        return productByUserDTO;
    }

    @Override
    public void deleteProductByUser(Long id) {
        productByUserRepository.deleteById(id);
    }
}
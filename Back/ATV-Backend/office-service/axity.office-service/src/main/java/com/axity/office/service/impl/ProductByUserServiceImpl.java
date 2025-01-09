package com.axity.office.service.impl;


import com.axity.office.commons.dto.ProductByUserDTO;
import com.axity.office.commons.dto.ProductDocumentDTO;
import com.axity.office.model.Branch;
import com.axity.office.model.BranchByUser;
import com.axity.office.model.ProductByUser;
import com.axity.office.model.ProductDocument;
import com.axity.office.persistence.BranchRepository;
import com.axity.office.persistence.ProductByUserRepository;
import com.axity.office.persistence.ProductDocumentRepository;
import com.axity.office.service.ProductByUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductByUserServiceImpl implements ProductByUserService {

    @Autowired
    private ProductByUserRepository productByUserRepository;

    @Autowired
    private ProductDocumentRepository productDocumentRepository;

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

    @Override
    public List<ProductByUserDTO> findAllByUser(String userId) {
        return productByUserRepository.findAllByUser(userId).stream().map(productByUser -> {
            ProductByUserDTO dto = new ProductByUserDTO();
            dto.setXpid(productByUser.getXpid());
            dto.setXpuser(productByUser.getXpuser());
            dto.setXpcopr(productByUser.getXpcopr());
            dto.setXpcodo(productDocumentRepository.findAll().stream()
                .filter(pd -> pd.getXpcopr().equals(productByUser.getXpcopr()))
                    .map(productDocument -> {return productDocument.getXpcodo();}
                    ).collect(Collectors.toList()));
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public List<ProductByUserDTO> updateByUser(String userId, List<String> products) {
        List<ProductByUser> currentList = productByUserRepository.findAllByUser(userId);

        if(!currentList.isEmpty() && currentList.size() > 0)
        {
            List<ProductByUser> objectsToRemove = currentList.stream()
                .filter(productByUser -> !products.contains(productByUser.getXpcopr()))
                .collect(Collectors.toList());

            objectsToRemove.forEach(productByUser->{
                productByUserRepository.deleteByUserAndProduct(productByUser.getXpuser(), productByUser.getXpcopr());
            });
        }

        if(!products.isEmpty() && products.size() > 0)
        {
            List<ProductByUser> objectsToInsert = products.stream()
                .filter(id -> !currentList.stream().anyMatch(b -> b.getXpcopr().equals(id)))
                .map(id -> {
                    ProductByUser newEntity = new ProductByUser();
                    newEntity.setXpcopr(id);
                    newEntity.setXpuser(userId);
                    return newEntity;
                })
                .collect(Collectors.toList());

            objectsToInsert.forEach(productByUser->{
                productByUserRepository.save(productByUser);
            });
        }
        return findAllByUser(userId);
    }
}
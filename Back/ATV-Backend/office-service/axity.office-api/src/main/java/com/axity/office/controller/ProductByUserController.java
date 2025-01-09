package com.axity.office.controller;


import com.axity.office.commons.dto.ProductByUserDTO;
import com.axity.office.facade.ProductByUserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/productbyuser")
public class ProductByUserController {

    @Autowired
    private ProductByUserFacade productByUserFacade;

    @PostMapping
    public ResponseEntity<ProductByUserDTO> createProductByUser(@RequestBody ProductByUserDTO productByUserDTO) {
        return ResponseEntity.ok(productByUserFacade.createProductByUser(productByUserDTO));
    }

    @GetMapping
    public ResponseEntity<List<ProductByUserDTO>> getAllProductByUsers() {
        return ResponseEntity.ok(productByUserFacade.getAllProductByUsers());
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<ProductByUserDTO>> read(@PathVariable String userId) {
        return ResponseEntity.ok(productByUserFacade.findAllByUser(userId));
    }

    @PutMapping("/{userId}")
    public ResponseEntity<List<ProductByUserDTO>> update(@PathVariable String userId, @RequestBody List<String> products) {
        return ResponseEntity.ok(productByUserFacade.updateByUser(userId, products));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductByUser(@PathVariable Long id) {
        productByUserFacade.deleteProductByUser(id);
        return ResponseEntity.noContent().build();
    }
}
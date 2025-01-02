package bancolombia.controller;

import bancolombia.commons.DTO.ProductByUserDTO;
import bancolombia.facade.ProductByUserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/productbyuser")
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

    @GetMapping("/{id}")
    public ResponseEntity<ProductByUserDTO> getProductByUserById(@PathVariable String id) {
        return ResponseEntity.ok(productByUserFacade.getProductByUserById(id));
    }

    @PutMapping
    public ResponseEntity<ProductByUserDTO> updateProductByUser(@RequestBody ProductByUserDTO productByUserDTO) {
        return ResponseEntity.ok(productByUserFacade.updateProductByUser(productByUserDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProductByUser(@PathVariable String id) {
        productByUserFacade.deleteProductByUser(id);
        return ResponseEntity.noContent().build();
    }
}
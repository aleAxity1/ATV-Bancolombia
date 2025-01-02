package bancolombia.facade;

import bancolombia.commons.DTO.ProductByUserDTO;

import java.util.List;

public interface ProductByUserFacade {
    ProductByUserDTO createProductByUser(ProductByUserDTO productByUserDTO);
    List<ProductByUserDTO> getAllProductByUsers();
    ProductByUserDTO getProductByUserById(String id);
    ProductByUserDTO updateProductByUser(ProductByUserDTO productByUserDTO);
    void deleteProductByUser(String id);
}
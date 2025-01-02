package bancolombia.facade.impl;

import bancolombia.commons.DTO.ProductDocumentDTO;
import bancolombia.facade.ProductDocumentFacade;
import bancolombia.service.ProductDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductDocumentFacadeImpl implements ProductDocumentFacade {

    @Autowired
    private ProductDocumentService productDocumentService;

    @Override
    public ProductDocumentDTO createProductDocument(ProductDocumentDTO productDocumentDTO) {
        return productDocumentService.createProductDocument(productDocumentDTO);
    }

    @Override
    public List<ProductDocumentDTO> getAllProductDocuments() {
        return productDocumentService.getAllProductDocuments();
    }

    @Override
    public ProductDocumentDTO getProductDocumentById(String id) {
        return productDocumentService.getProductDocumentById(id);
    }

    @Override
    public ProductDocumentDTO updateProductDocument(ProductDocumentDTO productDocumentDTO) {
        return productDocumentService.updateProductDocument(productDocumentDTO);
    }

    @Override
    public void deleteProductDocument(String id) {
        productDocumentService.deleteProductDocument(id);
    }
}
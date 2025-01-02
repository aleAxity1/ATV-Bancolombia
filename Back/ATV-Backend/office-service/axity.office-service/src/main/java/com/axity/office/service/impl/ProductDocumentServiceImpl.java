package bancolombia.service.impl;

import bancolombia.commons.DTO.ProductDocumentDTO;
import bancolombia.model.ProductDocument;
import bancolombia.persistence.ProductDocumentRepository;
import bancolombia.service.ProductDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductDocumentServiceImpl implements ProductDocumentService {

    @Autowired
    private ProductDocumentRepository productDocumentRepository;

    @Override
    public ProductDocumentDTO createProductDocument(ProductDocumentDTO productDocumentDTO) {
        ProductDocument productDocument = new ProductDocument();
        // Map DTO to Entity
        productDocument.setXpCopR(productDocumentDTO.getXpCopR());
        productDocument.setXpCodO(productDocumentDTO.getXpCodO());
        productDocument.setXpDsDo(productDocumentDTO.getXpDsDo());
        productDocument.setXpCta(productDocumentDTO.getXpCta());
        productDocument.setXpStDo(productDocumentDTO.getXpStDo());
        productDocument.setXpFeCa(productDocumentDTO.getXpFeCa());

        productDocument = productDocumentRepository.save(productDocument);

        // Map Entity to DTO
        return mapToDTO(productDocument);
    }

    @Override
    public List<ProductDocumentDTO> getAllProductDocuments() {
        return productDocumentRepository.findAll().stream().map(this::mapToDTO).collect(Collectors.toList());
    }

    @Override
    public ProductDocumentDTO getProductDocumentById(String id) {
        return productDocumentRepository.findById(id).map(this::mapToDTO).orElse(null);
    }

    @Override
    public ProductDocumentDTO updateProductDocument(ProductDocumentDTO productDocumentDTO) {
        ProductDocument productDocument = productDocumentRepository.findById(productDocumentDTO.getXpCopR()).orElse(null);
        if (productDocument != null) {
            // Update fields
            productDocument.setXpDsDo(productDocumentDTO.getXpDsDo());
            productDocument.setXpCta(productDocumentDTO.getXpCta());
            productDocument.setXpStDo(productDocumentDTO.getXpStDo());
            productDocument.setXpFeCa(productDocumentDTO.getXpFeCa());

            productDocument = productDocumentRepository.save(productDocument);
        }
        return mapToDTO(productDocument);
    }

    @Override
    public void deleteProductDocument(String id) {
        productDocumentRepository.deleteById(id);
    }

    private ProductDocumentDTO mapToDTO(ProductDocument productDocument) {
        ProductDocumentDTO dto = new ProductDocumentDTO();
        dto.setXpCopR(productDocument.getXpCopR());
        dto.setXpCodO(productDocument.getXpCodO());
        dto.setXpDsDo(productDocument.getXpDsDo());
        dto.setXpCta(productDocument.getXpCta());
        dto.setXpStDo(productDocument.getXpStDo());
        dto.setXpFeCa(productDocument.getXpFeCa());
        return dto;
    }
}
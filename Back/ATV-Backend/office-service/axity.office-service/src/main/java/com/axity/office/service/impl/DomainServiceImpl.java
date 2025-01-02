package bancolombia.service.impl;

import bancolombia.commons.DTO.DomainDTO;
import bancolombia.model.Domain;
import bancolombia.persistence.DomainRepository;
import bancolombia.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class DomainServiceImpl implements DomainService {

    @Autowired
    private DomainRepository domainRepository;

    @Override
    public DomainDTO createDomain(DomainDTO domainDTO) {
        Domain domain = new Domain();
        domain.setXddom(domainDTO.getXddom());
        domain.setXdname(domainDTO.getXdname());
        domain = domainRepository.save(domain);
        return convertToDTO(domain);
    }

    @Override
    public List<DomainDTO> getAllDomains() {
        return domainRepository.findAll().stream().map(this::convertToDTO).collect(Collectors.toList());
    }

    @Override
    public DomainDTO getDomainById(String id) {
        return domainRepository.findById(id).map(this::convertToDTO).orElse(null);
    }

    @Override
    public DomainDTO updateDomain(String id, DomainDTO domainDTO) {
        Domain domain = domainRepository.findById(id).orElseThrow(() -> new RuntimeException("Domain not found"));
        domain.setXdname(domainDTO.getXdname());
        domain = domainRepository.save(domain);
        return convertToDTO(domain);
    }

    @Override
    public void deleteDomain(String id) {
        domainRepository.deleteById(id);
    }

    private DomainDTO convertToDTO(Domain domain) {
        DomainDTO domainDTO = new DomainDTO();
        domainDTO.setXddom(domain.getXddom());
        domainDTO.setXdname(domain.getXdname());
        return domainDTO;
    }
}
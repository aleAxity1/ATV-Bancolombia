package bancolombia.facade.impl;

import bancolombia.commons.DTO.DomainDTO;
import bancolombia.facade.DomainFacade;
import bancolombia.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DomainFacadeImpl implements DomainFacade {

    @Autowired
    private DomainService domainService;

    @Override
    public DomainDTO createDomain(DomainDTO domainDTO) {
        return domainService.createDomain(domainDTO);
    }

    @Override
    public List<DomainDTO> getAllDomains() {
        return domainService.getAllDomains();
    }

    @Override
    public DomainDTO getDomainById(String id) {
        return domainService.getDomainById(id);
    }

    @Override
    public DomainDTO updateDomain(String id, DomainDTO domainDTO) {
        return domainService.updateDomain(id, domainDTO);
    }

    @Override
    public void deleteDomain(String id) {
        domainService.deleteDomain(id);
    }
}
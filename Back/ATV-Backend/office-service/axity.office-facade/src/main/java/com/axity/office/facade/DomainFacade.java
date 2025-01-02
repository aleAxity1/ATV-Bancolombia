package bancolombia.facade;

import bancolombia.commons.DTO.DomainDTO;

import java.util.List;

public interface DomainFacade {
    DomainDTO createDomain(DomainDTO domainDTO);
    List<DomainDTO> getAllDomains();
    DomainDTO getDomainById(String id);
    DomainDTO updateDomain(String id, DomainDTO domainDTO);
    void deleteDomain(String id);
}
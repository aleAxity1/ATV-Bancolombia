package bancolombia.controller;

import bancolombia.commons.DTO.DomainDTO;
import bancolombia.facade.DomainFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/domain")
public class DomainController {

    @Autowired
    private DomainFacade domainFacade;

    @PostMapping
    public ResponseEntity<DomainDTO> createDomain(@RequestBody DomainDTO domainDTO) {
        return ResponseEntity.ok(domainFacade.createDomain(domainDTO));
    }

    @GetMapping
    public ResponseEntity<List<DomainDTO>> getAllDomains() {
        return ResponseEntity.ok(domainFacade.getAllDomains());
    }

    @GetMapping("/{id}")
    public ResponseEntity<DomainDTO> getDomainById(@PathVariable String id) {
        return ResponseEntity.ok(domainFacade.getDomainById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<DomainDTO> updateDomain(@PathVariable String id, @RequestBody DomainDTO domainDTO) {
        return ResponseEntity.ok(domainFacade.updateDomain(id, domainDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteDomain(@PathVariable String id) {
        domainFacade.deleteDomain(id);
        return ResponseEntity.noContent().build();
    }
}
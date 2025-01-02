package bancolombia.controller;

import bancolombia.commons.DTO.BranchByUserDTO;
import bancolombia.facade.BranchByUserFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/branchbyuser")
public class BranchByUserController {

    @Autowired
    private BranchByUserFacade branchByUserFacade;

    @PostMapping
    public ResponseEntity<BranchByUserDTO> create(@RequestBody BranchByUserDTO branchByUserDTO) {
        return ResponseEntity.ok(branchByUserFacade.create(branchByUserDTO));
    }

    @GetMapping
    public ResponseEntity<List<BranchByUserDTO>> readAll() {
        return ResponseEntity.ok(branchByUserFacade.readAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BranchByUserDTO> read(@PathVariable String id) {
        return ResponseEntity.ok(branchByUserFacade.read(id));
    }

    @PutMapping
    public ResponseEntity<BranchByUserDTO> update(@RequestBody BranchByUserDTO branchByUserDTO) {
        return ResponseEntity.ok(branchByUserFacade.update(branchByUserDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        branchByUserFacade.delete(id);
        return ResponseEntity.ok().build();
    }
}
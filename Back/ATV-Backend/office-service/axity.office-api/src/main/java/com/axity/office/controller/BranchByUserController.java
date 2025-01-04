package com.axity.office.controller;

import com.axity.office.commons.dto.BranchByUserDTO;
import com.axity.office.facade.BranchByUserFacade;
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
    public ResponseEntity<BranchByUserDTO> read(@PathVariable Long id) {
        return ResponseEntity.ok(branchByUserFacade.read(id));
    }

    @PutMapping
    public ResponseEntity<BranchByUserDTO> update(@RequestBody BranchByUserDTO branchByUserDTO) {
        return ResponseEntity.ok(branchByUserFacade.update(branchByUserDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        branchByUserFacade.delete(id);
        return ResponseEntity.ok().build();
    }
}
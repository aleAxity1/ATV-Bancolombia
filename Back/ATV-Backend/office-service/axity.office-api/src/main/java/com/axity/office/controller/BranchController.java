package com.axity.office.controller;

import com.axity.office.commons.dto.BranchDTO;
import com.axity.office.facade.BranchFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/branch")
public class BranchController {

    @Autowired
    private BranchFacade branchFacade;

    @PostMapping
    public ResponseEntity<BranchDTO> createBranch(@RequestBody BranchDTO branchDTO) {
        return ResponseEntity.ok(branchFacade.createBranch(branchDTO));
    }

    @GetMapping
    public ResponseEntity<List<BranchDTO>> getAllBranches() {
        return ResponseEntity.ok(branchFacade.getAllBranches());
    }

    @GetMapping("/{id}")
    public ResponseEntity<BranchDTO> getBranchById(@PathVariable String id) {
        return ResponseEntity.ok(branchFacade.getBranchById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<BranchDTO> updateBranch(@PathVariable String id, @RequestBody BranchDTO branchDTO) {
        return ResponseEntity.ok(branchFacade.updateBranch(id, branchDTO));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBranch(@PathVariable String id) {
        branchFacade.deleteBranch(id);
        return ResponseEntity.noContent().build();
    }
}
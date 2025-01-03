package com.axity.office.service.impl;

import com.axity.office.commons.dto.BranchDTO;
import com.axity.office.model.Branch;
import com.axity.office.persistence.BranchRepository;
import com.axity.office.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BranchServiceImpl implements BranchService {

    @Autowired
    private BranchRepository branchRepository;

    @Override
    public BranchDTO createBranch(BranchDTO branchDTO) {
        Branch branch = new Branch();
        // Map DTO to Entity
        branch.setXnnmky(branchDTO.getXnnmky());
        branch.setXnclcd(branchDTO.getXnclcd());
        branch.setXnname(branchDTO.getXnname());
        // ... map other fields
        branchRepository.save(branch);
        return branchDTO;
    }

    @Override
    public List<BranchDTO> getAllBranches() {
        return branchRepository.findAll().stream().map(branch -> {
            BranchDTO dto = new BranchDTO();
            dto.setXnnmky(branch.getXnnmky());
            dto.setXnclcd(branch.getXnclcd());
            dto.setXnname(branch.getXnname());
            // ... map other fields
            return dto;
        }).collect(Collectors.toList());
    }

    @Override
    public BranchDTO getBranchById(String id) {
        Branch branch = branchRepository.findById(id).orElseThrow();
        BranchDTO dto = new BranchDTO();
        dto.setXnnmky(branch.getXnnmky());
        dto.setXnclcd(branch.getXnclcd());
        dto.setXnname(branch.getXnname());
        // ... map other fields
        return dto;
    }

    @Override
    public BranchDTO updateBranch(String id, BranchDTO branchDTO) {
        Branch branch = branchRepository.findById(id).orElseThrow();
        // Update fields
        branch.setXnclcd(branchDTO.getXnclcd());
        branch.setXnname(branchDTO.getXnname());
        // ... update other fields
        branchRepository.save(branch);
        return branchDTO;
    }

    @Override
    public void deleteBranch(String id) {
        branchRepository.deleteById(id);
    }
}
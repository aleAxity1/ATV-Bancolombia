package com.axity.office.facade.impl;

import com.axity.office.commons.dto.BranchDTO;
import com.axity.office.facade.BranchFacade;
import com.axity.office.service.BranchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BranchFacadeImpl implements BranchFacade {

    @Autowired
    private BranchService branchService;

    @Override
    public BranchDTO createBranch(BranchDTO branchDTO) {
        return branchService.createBranch(branchDTO);
    }

    @Override
    public List<BranchDTO> getAllBranches() {
        return branchService.getAllBranches();
    }

    @Override
    public BranchDTO getBranchById(String id) {
        return branchService.getBranchById(id);
    }

    @Override
    public BranchDTO updateBranch(String id, BranchDTO branchDTO) {
        return branchService.updateBranch(id, branchDTO);
    }

    @Override
    public void deleteBranch(String id) {
        branchService.deleteBranch(id);
    }
}
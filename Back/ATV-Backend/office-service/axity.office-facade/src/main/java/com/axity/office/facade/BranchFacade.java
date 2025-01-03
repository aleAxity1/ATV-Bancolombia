package com.axity.office.facade;

import com.axity.office.commons.dto.BranchDTO;

import java.util.List;

public interface BranchFacade {
    BranchDTO createBranch(BranchDTO branchDTO);
    List<BranchDTO> getAllBranches();
    BranchDTO getBranchById(String id);
    BranchDTO updateBranch(String id, BranchDTO branchDTO);
    void deleteBranch(String id);
}
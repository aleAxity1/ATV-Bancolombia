package com.axity.office.service;

import com.axity.office.commons.dto.BranchDTO;

import java.util.List;

public interface BranchService {
    BranchDTO createBranch(BranchDTO branchDTO);
    List<BranchDTO> getAllBranches();
    BranchDTO getBranchById(String id);
    BranchDTO updateBranch(String id, BranchDTO branchDTO);
    void deleteBranch(String id);
}
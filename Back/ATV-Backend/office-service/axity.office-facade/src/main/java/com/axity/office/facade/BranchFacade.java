package bancolombia.facade;

import bancolombia.commons.DTO.BranchDTO;

import java.util.List;

public interface BranchFacade {
    BranchDTO createBranch(BranchDTO branchDTO);
    List<BranchDTO> getAllBranches();
    BranchDTO getBranchById(String id);
    BranchDTO updateBranch(String id, BranchDTO branchDTO);
    void deleteBranch(String id);
}
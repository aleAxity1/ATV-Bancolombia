package bancolombia.facade;

import bancolombia.commons.DTO.BranchByUserDTO;

import java.util.List;

public interface BranchByUserFacade {
    BranchByUserDTO create(BranchByUserDTO branchByUserDTO);
    List<BranchByUserDTO> readAll();
    BranchByUserDTO read(String id);
    BranchByUserDTO update(BranchByUserDTO branchByUserDTO);
    void delete(String id);
}
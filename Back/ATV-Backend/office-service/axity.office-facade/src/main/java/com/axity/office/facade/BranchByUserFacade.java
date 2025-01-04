package com.axity.office.facade;

import com.axity.office.commons.dto.BranchByUserDTO;

import java.util.List;

public interface BranchByUserFacade {
    BranchByUserDTO create(BranchByUserDTO branchByUserDTO);
    List<BranchByUserDTO> readAll();
    BranchByUserDTO read(Long id);
    BranchByUserDTO update(BranchByUserDTO branchByUserDTO);
    void delete(Long id);
}
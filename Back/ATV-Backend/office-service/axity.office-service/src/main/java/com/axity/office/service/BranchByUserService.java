package com.axity.office.service;

import com.axity.office.commons.dto.BranchByUserDTO;

import java.util.List;

public interface BranchByUserService {
    BranchByUserDTO create(BranchByUserDTO branchByUserDTO);
    List<BranchByUserDTO> readAll();
    BranchByUserDTO read(Long id);
    BranchByUserDTO update(BranchByUserDTO branchByUserDTO);
    void delete(Long id);
}
package com.axity.office.facade.impl;

import com.axity.office.commons.dto.BranchByUserDTO;
import com.axity.office.facade.BranchByUserFacade;
import com.axity.office.service.BranchByUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BranchByUserFacadeImpl implements BranchByUserFacade {

    @Autowired
    private BranchByUserService branchByUserService;

    @Override
    public BranchByUserDTO create(BranchByUserDTO branchByUserDTO) {
        return branchByUserService.create(branchByUserDTO);
    }

    @Override
    public List<BranchByUserDTO> readAll() {
        return branchByUserService.readAll();
    }

    @Override
    public BranchByUserDTO read(Long id) {
        return branchByUserService.read(id);
    }

    @Override
    public BranchByUserDTO update(BranchByUserDTO branchByUserDTO) {
        return branchByUserService.update(branchByUserDTO);
    }

    @Override
    public void delete(Long id) {
        branchByUserService.delete(id);
    }
}
package bancolombia.facade.impl;

import bancolombia.commons.DTO.BranchByUserDTO;
import bancolombia.facade.BranchByUserFacade;
import bancolombia.service.BranchByUserService;
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
    public BranchByUserDTO read(String id) {
        return branchByUserService.read(id);
    }

    @Override
    public BranchByUserDTO update(BranchByUserDTO branchByUserDTO) {
        return branchByUserService.update(branchByUserDTO);
    }

    @Override
    public void delete(String id) {
        branchByUserService.delete(id);
    }
}